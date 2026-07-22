//package com.chinaex123.tbz.recoil.modifier;
//
//import com.chinaex123.tbz.config.TBZConfig;
//import com.chinaex123.tbz.init.TBZEnchantments;
//import com.chinaex123.tbz.recoil.RecoilModifierRegistry;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.item.ItemStack;
//
//import static com.chinaex123.tbz.recoil.RecoilModifierRegistry.RecoilType;
//
///**
// * 示例：同时修改水平和垂直后坐力的附魔
// */
//public class ExampleBothRecoilModifier implements RecoilModifierRegistry.RecoilModifier {
//
//    public static void register() {
//        RecoilModifierRegistry.register(new ExampleBothRecoilModifier());
//    }
//
//    @Override
//    public boolean shouldApply(RecoilType type, LivingEntity player, ItemStack itemStack) {
//        int level = itemStack.getEnchantmentLevel(TBZEnchantments.YOUR_ENCHANTMENT.get());
//        return level > 0 && player.isSprinting(); // 自定义条件
//    }
//
//    @Override
//    public double onEntityHurtByGun(double value, RecoilType type, LivingEntity player, ItemStack itemStack) {
//        float reduction = TBZConfig.YOUR_ENCHANTMENT_RECOIL_REDUCTION.get().floatValue();
//
//        if (type == RecoilType.PITCH) {
//            // 垂直：用除法
//            return value / (1.0f - reduction);
//        } else {
//            // 水平：用乘法
//            return value * (1.0f + reduction);
//        }
//    }
//}