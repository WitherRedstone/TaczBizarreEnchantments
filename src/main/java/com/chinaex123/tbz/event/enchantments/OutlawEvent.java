package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.GunReloadSpeedHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.event.common.GunReloadEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;

/**
 * 不法之徒附魔事件处理类
 * <p>
 * 功能：爆头击杀后获得换弹加速效果
 * 机制：
 * <ol>
 *   <li>玩家爆头命中敌人时，在武器NBT中记录标记和时间</li>
 *   <li>在有效时间窗口内（60刻）击杀敌人，触发换弹加速效果</li>
 *   <li>换弹开始时检测标记，如果有效则加速换弹</li>
 *   <li>换弹完成或取消时清除加速标记</li>
 * </ol>
 */
public class OutlawEvent {

    /** NBT存储键：爆头击杀标记 */
    private static final String HEADSHOT_KILL_TAG = "OutlawHeadshotKill";
    /** NBT存储键：击杀时间戳 */
    private static final String KILL_TIME_TAG = "OutlawKillTime";
    /** NBT存储键：换弹加速标记 */
    public static final String RELOAD_SPEED_TAG = "OutlawReloadSpeed";
    /** 有效时间窗口（游戏刻） */
    private static final int VALID_KILL_TICKS = 60;

    /**
     * 枪械伤害事件：不法之徒
     * 武器爆头命中敌人时，记录命中标记和时间
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有不法之徒附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel > 0) {
            // 射击时清除换弹加速标记
            GunReloadSpeedHelper.clearSpeed(gun, RELOAD_SPEED_TAG);

            // 仅处理爆头命中
            if (event.isHeadShot()) {
                Entity hurtEntity = event.getHurtEntity();
                if (hurtEntity instanceof LivingEntity) {
                    // 记录爆头命中标记和当前游戏时间
                    GunReloadSpeedHelper.recordHit(gun, player, HEADSHOT_KILL_TAG, KILL_TIME_TAG);
                }
            }
        }
    }

    /**
     * 实体死亡事件：不法之徒
     * 如果爆头命中在有效时间窗口内，则设置换弹加速标记
     *
     * @param player 击杀者玩家
     * @param killedEntity 被击杀的实体
     * @param gun 使用的枪械物品
     */
    public static void onKill(Player player, Entity killedEntity, ItemStack gun) {
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel <= 0) return;

        // 验证爆头击杀是否在有效时间窗口内，如果是则设置换弹加速标记
        GunReloadSpeedHelper.validateKillAndSetSpeed(
                gun, player,
                HEADSHOT_KILL_TAG,
                RELOAD_SPEED_TAG,
                KILL_TIME_TAG,
                VALID_KILL_TICKS
        );
    }

    /**
     * 换弹开始事件：不法之徒
     * 检测到有效换弹加速标记时，触发换弹加速并同步到客户端
     *
     * @param event 换弹事件
     */
    public static void onGunReload(GunReloadEvent event) {
        // 仅在服务端执行
        if (event.getLogicalSide() != LogicalSide.SERVER) return;

        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) return;

        ItemStack gun = event.getGunItemStack();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.OUTLAW.get());
        if (enchantLevel <= 0) {
            // 没有附魔时清理标记
            GunReloadSpeedHelper.clearSpeed(gun, RELOAD_SPEED_TAG);
            return;
        }

        // 检查加速标记是否有效，有效则触发换弹加速
        GunReloadSpeedHelper.checkAndTriggerSpeed(
                gun, player,
                RELOAD_SPEED_TAG,
                KILL_TIME_TAG,
                VALID_KILL_TICKS
        );
    }

    /**
     * 换弹完成事件：不法之徒
     * 在换弹完成或取消时调用，确保标记被清除
     *
     * @param gun 枪械物品
     */
    public static void onGunFinishReload(ItemStack gun) {
        if (gun.isEmpty()) return;

        GunReloadSpeedHelper.clearSpeed(gun, RELOAD_SPEED_TAG);
    }
}