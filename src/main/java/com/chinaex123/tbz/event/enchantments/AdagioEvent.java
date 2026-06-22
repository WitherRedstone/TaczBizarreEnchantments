//package com.chinaex123.tbz.event.enchantments;
//
//import com.chinaex123.tbz.TBZMod;
//import com.chinaex123.tbz.config.TBZConfig;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.tacz.guns.api.event.common.EntityHurtByGunEvent;
//import com.tacz.guns.resource.pojo.data.attachment.Modifier;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//
//public class AdagioEvent {
//
//    public static final String BUFF_ACTIVE_TAG = "AdagioBuffActive";
//    public static final String BUFF_EXPIRE_TAG = "AdagioBuffExpire";
//    public static final String TEMP_MODIFIER_TAG = "AdagioTempModifier";
//
//    // 持续时间：5秒 = 100 tick
//    public static final int BUFF_DURATION_TICKS = 100;
//    // 射速降低比例：减少四分之一 = 乘以 0.75
//    public static final double RPM_MULTIPLIER = 0.75;
//    // 伤害增加比例：+25%
//    public static final float DAMAGE_MULTIPLIER = 1.25f;
//
//    public static void onKill(Player player, ItemStack gun) {
//        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
//        if (enchantLevel <= 0) return;
//
//        CompoundTag tag = gun.getOrCreateTag();
//
//        // 激活 Buff
//        tag.putBoolean(BUFF_ACTIVE_TAG, true);
//        tag.putLong(BUFF_EXPIRE_TAG, player.level().getGameTime() + BUFF_DURATION_TICKS);
//
//        // 添加临时射速 modifier
//        applyTempRpmModifier(gun);
//
//        TBZMod.LOGGER.info("【柔缓】击杀触发！玩家: {}, 附魔等级: {}, 效果持续5秒: 射速减少25%, 伤害增加25%",
//                player.getName().getString(), enchantLevel);
//    }
//
//    /**
//     * 应用临时射速 modifier（通过 NBT 存储）
//     */
//    private static void applyTempRpmModifier(ItemStack gun) {
//        CompoundTag tag = gun.getOrCreateTag();
//
//        // 创建临时 modifier 的 NBT 数据
//        CompoundTag modifierTag = new CompoundTag();
//        modifierTag.putDouble("multiplier", RPM_MULTIPLIER);
//        modifierTag.putDouble("addend", 0);
//        modifierTag.putDouble("percent", 0);
//        modifierTag.putString("function", "");
//
//        tag.put(TEMP_MODIFIER_TAG, modifierTag);
//    }
//
//    /**
//     * 移除临时射速 modifier
//     */
//    private static void removeTempRpmModifier(ItemStack gun) {
//        CompoundTag tag = gun.getOrCreateTag();
//        tag.remove(TEMP_MODIFIER_TAG);
//    }
//
//    /**
//     * 创建并返回一个临时射速 Modifier 对象
//     */
//    public static Modifier createTempRpmModifier() {
//        Modifier modifier = new Modifier();
//        // 使用已弃用的 setter 方法（但仍然可用）
//        modifier.setAddend(0);
//        modifier.setPercent(0);
//        // multiplier 默认为 1.0，我们需要通过反射设置 multiplier
//        try {
//            java.lang.reflect.Field multiplierField = Modifier.class.getDeclaredField("multiplier");
//            multiplierField.setAccessible(true);
//            multiplierField.set(modifier, RPM_MULTIPLIER);
//        } catch (Exception e) {
//            TBZMod.LOGGER.error("设置 multiplier 失败", e);
//        }
//        return modifier;
//    }
//
//    public static void tickCheck(Player player, ItemStack gun) {
//        if (gun.isEmpty()) return;
//
//        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
//        if (enchantLevel <= 0) {
//            clearBuff(gun);
//            return;
//        }
//
//        CompoundTag tag = gun.getOrCreateTag();
//        boolean isActive = tag.getBoolean(BUFF_ACTIVE_TAG);
//
//        if (isActive) {
//            long expireTime = tag.getLong(BUFF_EXPIRE_TAG);
//            long currentTime = player.level().getGameTime();
//
//            if (currentTime >= expireTime) {
//                clearBuff(gun);
//                TBZMod.LOGGER.info("【柔缓】5秒效果已结束，射速和伤害恢复正常");
//            }
//        }
//    }
//
//    private static void clearBuff(ItemStack gun) {
//        CompoundTag tag = gun.getOrCreateTag();
//        tag.putBoolean(BUFF_ACTIVE_TAG, false);
//        tag.remove(BUFF_EXPIRE_TAG);
//        removeTempRpmModifier(gun);
//    }
//
//    public static boolean isBuffActive(ItemStack gun) {
//        if (gun == null || gun.isEmpty()) return false;
//        CompoundTag tag = gun.getOrCreateTag();
//        return tag.getBoolean(BUFF_ACTIVE_TAG);
//    }
//
//    public static double getRpmMultiplier(ItemStack gun) {
//        if (isBuffActive(gun)) {
//            return RPM_MULTIPLIER;
//        }
//        return 1.0;
//    }
//
//    public static float getDamageMultiplier(ItemStack gun) {
//        if (isBuffActive(gun)) {
//            return DAMAGE_MULTIPLIER;
//        }
//        return 1.0f;
//    }
//
//    public static float getRemainingTime(ItemStack gun, Player player) {
//        if (!isBuffActive(gun)) return 0;
//        CompoundTag tag = gun.getOrCreateTag();
//        long expireTime = tag.getLong(BUFF_EXPIRE_TAG);
//        long currentTime = player.level().getGameTime();
//        long remainingTicks = Math.max(0, expireTime - currentTime);
//        return remainingTicks / 20.0f;
//    }
//
//    private static final ThreadLocal<ItemStack> CURRENT_GUN = new ThreadLocal<>();
//
//    public static void setCurrentGun(ItemStack gun) {
//        CURRENT_GUN.set(gun);
//    }
//
//    public static void clearCurrentGun() {
//        CURRENT_GUN.remove();
//    }
//
//    public static ItemStack getCurrentGun() {
//        return CURRENT_GUN.get();
//    }
//
//    public static void onEntityHurtByGun(EntityHurtByGunEvent.Pre event) {
//        LivingEntity attacker = event.getAttacker();
//        if (!(attacker instanceof Player player)) return;
//
//        ItemStack gun = player.getMainHandItem();
//        if (gun.isEmpty()) return;
//
//        int enchantLevel = gun.getEnchantmentLevel(TBZEnchantments.ADAGIO.get());
//        if (enchantLevel <= 0) return;
//
//        if (!isBuffActive(gun)) return;
//
//        float damageMultiplier = getDamageMultiplier(gun);
//        float originalDamage = event.getBaseAmount();
//        float newDamage = originalDamage * damageMultiplier;
//        event.setBaseAmount(newDamage);
//
//        float remainingTime = getRemainingTime(gun, player);
//
//        TBZMod.LOGGER.info("【柔缓】伤害加成生效！伤害增加25%: {} → {}, 效果剩余 {} 秒",
//                originalDamage, newDamage, remainingTime);
//    }
//}