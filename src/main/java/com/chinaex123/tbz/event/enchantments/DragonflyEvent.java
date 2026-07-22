package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.utils.ExplosionUtils;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 蜻蜓附魔的事件处理类
 * <p>
 * 功能：精准击杀可产生爆炸伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>枪械命中目标时检测是否为爆头（头部命中）</li>
 *   <li>爆头命中时记录标记和命中时间到枪械NBT</li>
 *   <li>后续击杀目标时检查是否存在有效的爆头命中标记</li>
 *   <li>若爆头时间到击杀时间的间隔在有效窗口内（60刻/3秒），判定为有效爆头击杀</li>
 *   <li>有效爆头击杀触发爆炸效果，对目标造成额外范围伤害</li>
 *   <li>爆炸伤害随附魔等级提升：基础伤害 + 每级额外伤害</li>
 *   <li>爆炸有随机溅射伤害范围（最小值~最大值之间随机）</li>
 *   <li>触发后或超时后清除爆头标记，防止重复触发</li>
 *   <li>若爆头后未在窗口期内击杀目标，标记自动失效（防止延迟触发）</li>
 * </ol>
 */
public class DragonflyEvent {

    /** 是否获得爆头击杀标记 */
    public static final String HEADSHOT_KILL_TAG = "DragonflyHeadshotKill";
    /** 爆头击杀发生时间 */
    public static final String KILL_TIME_TAG = "DragonflyKillTime";
    /** 有效时间窗口 */
    public static final int VALID_KILL_TICKS = 60;

    /**
     * 枪械伤害事件：蜻蜓
     * 记录爆头命中次数，等待后续击杀确认
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
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.DRAGONFLY.get());
        if (enchantLevel <= 0) return;

        // 仅处理爆头命中
        if (!event.isHeadShot()) return;

        // 标记爆头命中，记录时间
        CompoundTag tag = gun.getOrCreateTag();
        tag.putBoolean(HEADSHOT_KILL_TAG, true);
        tag.putLong(KILL_TIME_TAG, player.level().getGameTime());
    }

    /**
     * 实体死亡事件：蜻蜓
     * 验证爆头命中是否导致了击杀，如果有效则触发爆炸效果
     *
     * @param player 击杀者
     * @param gun 使用的枪械
     * @param target 被击杀的目标
     */
    public static void onKill(Player player, ItemStack gun, LivingEntity target) {
        // 检查附魔等级
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.DRAGONFLY.get());
        if (enchantLevel <= 0) return;

        CompoundTag tag = gun.getOrCreateTag();
        // 没有爆头命中标记，忽略
        if (!tag.getBoolean(HEADSHOT_KILL_TAG)) return;

        long currentTime = player.level().getGameTime();
        long killTime = tag.getLong(KILL_TIME_TAG);

        // 如果爆头时间到击杀时间超过有效窗口，清除标记（爆头未导致击杀或超时）
        if (currentTime - killTime > VALID_KILL_TICKS) {
            tag.putBoolean(HEADSHOT_KILL_TAG, false);
            return;
        }

        // 触发爆炸效果
        float damage = TBZConfig.DRAGONFLY_BASE_DAMAGE.get().floatValue()
                + TBZConfig.DRAGONFLY_DAMAGE_PER_LEVEL.get().floatValue() * enchantLevel;
        float splashMin = TBZConfig.DRAGONFLY_SPLASH_MIN.get().floatValue();
        float splashMax = TBZConfig.DRAGONFLY_SPLASH_MAX.get().floatValue();
        double range = TBZConfig.DRAGONFLY_RANGE.get();
        ExplosionUtils.dealSmallExplosionDamage(target, damage, splashMin, splashMax, range);

        // 清除爆头击杀标记
        tag.putBoolean(HEADSHOT_KILL_TAG, false);
    }
}