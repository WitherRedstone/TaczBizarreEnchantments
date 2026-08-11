package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.funky_effect_lib.init.FELEffects;
import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * 十六进制附魔的事件处理类
 * <p>
 * 功能：每4发削弱，每16发增伤
 * <p>
 * 机制：
 * <ol>
 *   <li>在武器NBT中追踪射击次数</li>
 *   <li>每第4发子弹在命中时给目标添加削弱效果</li>
 *   <li>每第16发子弹在命中时造成额外33%伤害</li>
 *   <li>射击计数会持续累积，不会重置</li>
 * </ol>
 */
public class VexadecimalEvent {

    /** NBT存储键：射击计数 **/
    private static final String SHOT_COUNT_TAG = "Vexadecimal_ShotCount";

    /**
     * 枪械伤害事件处理 - 十六进制
     * 每4发削弱，每16发增伤
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        // 检查是否有十六进制附魔
        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.VEXADECIMAL.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        CompoundTag tag = gun.getOrCreateTag();

        // 增加射击计数
        int shotCount = tag.getInt(SHOT_COUNT_TAG) + 1;
        tag.putInt(SHOT_COUNT_TAG, shotCount);

        // 获取被击中的实体
        Entity hurtEntity = event.getHurtEntity();
        if (!(hurtEntity instanceof LivingEntity target)) return;

        // 每4发子弹：给目标添加削弱效果
        if (shotCount % 4 == 0) {
            int duration = TBZServerConfig.VEXADECIMAL_WEAKNESS_DURATION.get();
            int amplifier = TBZServerConfig.VEXADECIMAL_WEAKNESS_LEVEL.get() - 1;
            target.addEffect(new MobEffectInstance(FELEffects.VULNERABLE.get(), duration * 20, amplifier, false, false));
        }

        // 每16发子弹：造成额外伤害
        if (shotCount % 16 == 0) {
            float extraDamagePercent = TBZServerConfig.VEXADECIMAL_EXTRA_DAMAGE_PERCENT.get().floatValue();
            float extraDamage = event.getBaseAmount() * extraDamagePercent;
            event.setBaseAmount(event.getBaseAmount() + extraDamage);
        }
    }
}