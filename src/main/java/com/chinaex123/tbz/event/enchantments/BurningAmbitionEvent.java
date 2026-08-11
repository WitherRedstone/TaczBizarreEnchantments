package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.api.event.Scorch.ScorchAPI;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 燃烧野心附魔的事件处理类
 * <p>
 * 功能：造成持续伤害会点燃目标
 * <p>
 * 机制：
 * <ol>
 *   <li>每次命中目标时增加燃烧层数</li>
 *   <li>每N发子弹叠一次燃烧层数（可配置）</li>
 *   <li>使用FLB模组的ScorchAPI管理燃烧层数</li>
 * </ol>
 */
public class BurningAmbitionEvent {

    /** NBT存储键：当前射击次数 */
    private static final String SHOT_COUNT_TAG = "BurningAmbitionShotCount";

    /**
     * 枪械伤害事件：燃烧野心
     * 造成持续伤害会点燃目标
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.BURNING_AMBITION.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 获取配置
        int shotsPerStack = TBZServerConfig.BURNING_AMBITION_SHOTS_PER_STACK.get();
        int stacksPerHit = TBZServerConfig.BURNING_AMBITION_STACKS_PER_HIT.get();

        // 获取或创建NBT标签
        CompoundTag tag = gun.getOrCreateTag();
        int shotCount = tag.getInt(SHOT_COUNT_TAG);

        // 增加射击计数
        shotCount++;
        tag.putInt(SHOT_COUNT_TAG, shotCount);

        // 检查是否达到叠层条件
        if (shotCount >= shotsPerStack) {
            // 重置计数
            tag.putInt(SHOT_COUNT_TAG, 0);
            
            // 使用FLB模组的ScorchAPI增加燃烧层数
            ScorchAPI.addScorchStacks(target, stacksPerHit);
        }
    }
}