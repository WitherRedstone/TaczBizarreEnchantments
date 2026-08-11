package com.chinaex123.tbz.event.enchantments;

import com.chinaex123.tbz.config.TBZServerConfig;
import com.chinaex123.tbz.init.TBZEnchantments;
import com.chinaex123.tbz.network.hud.HUDPacketHandler;
import com.chinaex123.tbz.network.hud.TriggeredEnchantmentSyncPacket;
import com.chinaex123.tbz.utils.AmmoUtils;
import com.chinaex123.tbz.utils.GunEnchantmentHelper;
import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
import com.tacz.guns.api.item.IGun;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.PacketDistributor;

/**
 * 恶意触碰附魔的事件处理类
 * <p>
 * 功能：弹匣中的最后一发弹药会吸收使用者的生命力来造成额外伤害
 * <p>
 * 机制：
 * <ol>
 *   <li>检测当前是否是弹匣中的最后一发弹药</li>
 *   <li>最后一发弹药不会打没，会从后备弹药中扣除</li>
 *   <li>射击最后一发时，立刻补充一发子弹到弹匣</li>
 *   <li>使用者扣一颗心（2滴血），最多扣到剩1颗心（2滴血）</li>
 *   <li>每颗心提供5%额外伤害</li>
 *   <li>触发时显示GUI文字提示</li>
 * </ol>
 */
public class TouchOfMaliceEvent {

    /**
     * 枪械伤害事件：恶意触碰
     * 最后一发弹药吸收生命力造成额外伤害
     * <p>
     * 机制：
     * <ol>
     *   <li>仅在弹匣只剩1发时触发</li>
     *   <li>从后备弹药补充1发到弹匣（TACZ消耗后仍保持1发）</li>
     *   <li>血量>1心时：扣1心+增伤+显示GUI</li>
     *   <li>血量<=1心时：只增伤+显示GUI（不扣血）</li>
     * </ol>
     *
     * @param event 枪械伤害事件
     */
    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
        LivingEntity attacker = event.getAttacker();
        if (!(attacker instanceof Player player)) return;

        ItemStack gun = player.getMainHandItem();
        if (gun.isEmpty()) return;

        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.TOUCH_OF_MALICE.get());
        if (enchantLevel <= 0) return;

        IGun iGun = IGun.getIGunOrNull(gun);
        if (iGun == null) return;

        int currentAmmo = GunEnchantmentHelper.getCurrentAmmo(gun);

        // TACZ在Pre事件前已扣弹药，所以currentAmmo==0表示实际弹匣1发（最后一发正在发射）
        if (currentAmmo != 0) return;

        // 获取备弹ID
        ResourceLocation ammoId = GunEnchantmentHelper.getAmmoId(gun).orElse(null);
        if (ammoId == null) return;

        // 检查备弹是否足够
        int availableAmmo = AmmoUtils.countAmmoInInventory(player, ammoId);
        if (availableAmmo <= 0) return;

        // 检查玩家血量
        float currentHealth = player.getHealth();
        float maxHealth = player.getMaxHealth();
        float minHealth = 2.0f; // 最少保留1颗心（2滴血）

        // 消耗备弹并补充弹匣（Pre中补充，使弹匣保持1发）
        AmmoUtils.consumeAmmoFromInventory(player, ammoId, 1);
        iGun.setCurrentAmmoCount(gun, 1);

        // 每颗心提供的额外伤害百分比
        float damageBonusPercent = TBZServerConfig.TOUCH_OF_MALICE_DAMAGE_BONUS_PER_HEART.get().floatValue();

        if (currentHealth > minHealth) {
            // 血量>1心：扣1心 + 计算已扣心数 + 增伤
            float healthAfterDrain = Math.max(minHealth, currentHealth - 2.0f);
            player.setHealth(healthAfterDrain);

            // 计算已扣除的 hearts 数量（每个心2滴血）
            float heartsDrained = (float) Math.floor((maxHealth - healthAfterDrain) / 2.0f);
            float extraDamage = event.getBaseAmount() * damageBonusPercent * heartsDrained;
            event.setBaseAmount(event.getBaseAmount() + extraDamage);
        } else {
            // 血量<=1心：只计算当前已扣心数增伤（不扣血）
            float heartsDrained = (float) Math.floor((maxHealth - currentHealth) / 2.0f);
            if (heartsDrained > 0) {
                float extraDamage = event.getBaseAmount() * damageBonusPercent * heartsDrained;
                event.setBaseAmount(event.getBaseAmount() + extraDamage);
            }
        }

        // 显示GUI文字提示
        if (player instanceof ServerPlayer serverPlayer) {
            long currentTime = serverPlayer.level().getGameTime();
            HUDPacketHandler.INSTANCE.send(
                    PacketDistributor.PLAYER.with(() -> serverPlayer),
                    new TriggeredEnchantmentSyncPacket(player.getUUID(), "touch_of_malice", currentTime)
            );
        }
    }
}