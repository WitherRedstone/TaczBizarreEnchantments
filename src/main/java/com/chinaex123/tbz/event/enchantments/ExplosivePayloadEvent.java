package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ExplosionUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.server.AmmoHitBlockEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

/**
 * 高爆载荷附魔的事件处理类
 * <p>
 * 功能：弹药在命中时爆炸，产生范围效果
 * 机制：
 * 1. 命中实体目标时在目标位置触发爆炸，对范围内所有实体造成溅射伤害
 * 2. 命中方块时在击中位置触发爆炸视觉效果（仅特效，不造成伤害）
 * 3. 爆炸伤害随附魔等级提升：基础伤害 + 每级额外伤害
 * 4. 爆炸有随机溅射伤害范围（最小值~最大值之间随机）
 * 5. 爆炸影响范围内的所有实体（造成伤害）
 * 6. 方块命中触发仅用于视觉表现（粒子、爆炸效果），不造成伤害
 * 7. 每次命中独立触发，无冷却时间限制
 */
public class ExplosivePayloadEvent {

    /**
     * 枪械伤害事件处理
     * 当附魔的枪械击中实体目标时，在目标位置触发小爆炸效果
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_PAYLOAD.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 计算爆炸伤害：基础伤害 + 等级 × 每级伤害增量
        float damage = TBZConfig.EXPLOSIVE_PAYLOAD_BASE_DAMAGE.get().floatValue()
                + TBZConfig.EXPLOSIVE_PAYLOAD_DAMAGE_PER_LEVEL.get().floatValue() * enchantLevel;

        // 获取溅射伤害范围和数值（从配置读取）
        float splashMin = TBZConfig.EXPLOSIVE_PAYLOAD_SPLASH_MIN.get().floatValue(); // 溅射伤害最小值
        float splashMax = TBZConfig.EXPLOSIVE_PAYLOAD_SPLASH_MAX.get().floatValue(); // 溅射伤害最大值
        double range = TBZConfig.EXPLOSIVE_PAYLOAD_RANGE.get(); // 爆炸范围（半径，格）

        // 在目标位置触发小爆炸效果（包含伤害和视觉效果）
        ExplosionUtils.dealSmallExplosionDamage(target, damage, splashMin, splashMax, range);
    }

    /**
     * 子弹击中方块事件处理
     * 当附魔的枪械的子弹击中方块时，在击中位置触发小爆炸效果
     * 例如：子弹射到地面、墙壁时产生爆炸
     *
     * @param event 子弹击中方块事件
     */
    public static void onAmmoHitBlock(AmmoHitBlockEvent event) {
        // 获取子弹的发射者（玩家）
        Entity owner = event.getAmmo().getOwner();
        if (!(owner instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.EXPLOSIVE_PAYLOAD.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        // 获取溅射伤害范围和数值
        float splashMin = TBZConfig.EXPLOSIVE_PAYLOAD_SPLASH_MIN.get().floatValue();
        float splashMax = TBZConfig.EXPLOSIVE_PAYLOAD_SPLASH_MAX.get().floatValue();
        double range = TBZConfig.EXPLOSIVE_PAYLOAD_RANGE.get();

        // 获取子弹命中方块的位置
        Vec3 hitPos = event.getHitResult().getLocation();

        // 在命中位置触发小爆炸效果（仅视觉效果，不造成直接伤害）
        ExplosionUtils.createSmallExplosionEffect(event.getLevel(), hitPos, splashMin, splashMax, range);
    }
}