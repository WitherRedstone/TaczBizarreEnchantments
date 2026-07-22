package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 羸弱能量球附魔的事件处理类
 * <p>
 * 功能：对同一目标造成持续伤害会生成经验球
 * <p>
 * 机制：
 * <ol>
 *   <li>每发射一颗子弹增加1层射击计数
 *   <li>首次射击时缓存当前枪械的弹匣容量
 *   <li>射击计数达到"弹匣容量 × 触发比例"时触发效果
 *   <li>触发比例随附魔等级提升而降低
 *   <li>触发后在命中目标位置生成随机数量的经验球（每个经验球提供1点经验）
 *   <li>触发后重置射击计数，开始新一轮积累
 *   <li>换弹时重置所有计数和缓存数据，开始全新的弹匣周期
 * </ol>
 */
public class AttritionOrbsEvent {

    /** 当前弹匣累计射击次数 */
    private static final String SHOT_COUNT_TAG = "AttritionOrbsShotCount";
    /** 弹匣容量 */
    private static final String MAGAZINE_SIZE_TAG = "AttritionOrbsMagazineSize";
    /** 上一tick的弹药数 */
    private static final String PREV_AMMO_TAG = "AttritionOrbsPrevAmmo";

    /**
     * 枪械伤害事件：羸弱能量球
     * 检测射击行为并累计射击次数，达到阈值后在目标位置生成经验球
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ATTRITION_ORBS.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();
        int currentAmmo = iGun.getCurrentAmmoCount(gun);
        int prevAmmo = tag.getInt(PREV_AMMO_TAG);
        tag.putInt(PREV_AMMO_TAG, currentAmmo);

        // 检测射击：弹药减少时累计射击次数
        if (prevAmmo > currentAmmo && prevAmmo > 0) {
            int shotsFired = tag.getInt(SHOT_COUNT_TAG) + (prevAmmo - currentAmmo);
            tag.putInt(SHOT_COUNT_TAG, shotsFired);

            // 首次射击时获取并缓存弹匣容量
            if (tag.getInt(MAGAZINE_SIZE_TAG) == 0) {
                Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(iGun.getGunId(gun));
                if (gunIndexOpt.isPresent()) {
                    int magazineSize = gunIndexOpt.get().getGunData().getAmmoAmount();
                    tag.putInt(MAGAZINE_SIZE_TAG, magazineSize);
                }
            }

            int magazineSize = tag.getInt(MAGAZINE_SIZE_TAG);
            if (magazineSize > 0) {
                // 计算触发所需射击比例（附魔等级越高，所需比例越低）
                // 公式：基础比例 - (等级 - 1) × 每级减少量
                double requiredPercentage = TBZConfig.ATTRITION_ORBS_BASE_PERCENTAGE.get()
                        - (enchantLevel - 1) * TBZConfig.ATTRITION_ORBS_PERCENTAGE_REDUCTION_PER_LEVEL.get();
                int requiredShots = (int) Math.ceil(magazineSize * requiredPercentage);

                // 检查是否达到触发条件
                if (shotsFired >= requiredShots) {
                    // 获取生成经验球的数量范围
                    int minOrbs = TBZConfig.ATTRITION_ORBS_MIN_ORBS.get();
                    int maxOrbs = TBZConfig.ATTRITION_ORBS_MAX_ORBS.get();
                    // 随机生成数量（范围内）
                    int orbCount = player.getRandom().nextInt(maxOrbs - minOrbs + 1) + minOrbs;

                    // 在服务端生成经验球
                    if (player.level() instanceof ServerLevel serverLevel) {
                        for (int i = 0; i < orbCount; i++) {
                            ExperienceOrb orb = new ExperienceOrb(serverLevel, target.getX(), target.getY(), target.getZ(), 1);
                            serverLevel.addFreshEntity(orb);
                        }
                    }

                    // 重置射击计数，等待下次触发
                    tag.putInt(SHOT_COUNT_TAG, 0);
                }
            }
        }
    }

    /**
     * 换弹开始事件：羸弱能量球
     * 重置所有计数，准备下一个弹匣的射击统计
     *
     * @param event 枪械换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ATTRITION_ORBS.get());
        if (enchantLevel <= 0) return;

        // 重置所有计数器
        CompoundTag tag = gun.getOrCreateTag();
        tag.putInt(SHOT_COUNT_TAG, 0);
        tag.putInt(MAGAZINE_SIZE_TAG, 0);
        tag.putInt(PREV_AMMO_TAG, 0);
    }
}