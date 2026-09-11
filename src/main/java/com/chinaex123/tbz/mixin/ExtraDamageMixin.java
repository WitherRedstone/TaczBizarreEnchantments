//package com.chinaex123.tbz.mixin;
//
//import com.google.common.collect.Lists;
//import com.tacz.guns.api.entity.IGunOperator;
//import com.tacz.guns.resource.pojo.data.gun.ExtraDamage;
//import net.minecraft.client.Minecraft;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import org.spongepowered.asm.mixin.gen.Accessor;
//
//import java.util.LinkedList;
//
///**
// * 额外伤害混入类
// * <p>
// * 功能：用于修改枪械的距离伤害衰减，实现测距仪附魔的"提高优势射程"效果
// * <p>
// * TACZ 会自动根据优势射程计算距离伤害衰减，无需手动修改距离伤害调整表
// */
//@Mixin(value = ExtraDamage.class, remap = false)
//public abstract class ExtraDamageMixin {
//
//    @Shadow
//    private LinkedList<ExtraDamage.DistanceDamagePair> damageAdjust;
//
//    @Accessor("damageAdjust")
//    public abstract LinkedList<ExtraDamage.DistanceDamagePair> getDamageAdjustField();
//
//    @Accessor("damageAdjust")
//    public abstract void setDamageAdjustField(LinkedList<ExtraDamage.DistanceDamagePair> value);
//
//    private LinkedList<ExtraDamage.DistanceDamagePair> originalDamageAdjust = null;
//
//    /**
//     * 修改距离伤害调整方法
//     * <p>
//     * 已废弃：此方法不再使用，现在通过修改 GunProperties.EFFECTIVE_RANGE 来实现射程扩展
//     * 保留此方法仅用于兼容性，实际不会执行任何操作
//     *
//     * @param cir 回调信息返回对象，包含原始的距离伤害调整列表
//     */
//    @Inject(
//            method = "getDamageAdjust",
//            at = @At("RETURN"),
//            cancellable = true
//    )
//    private void modifyDamageAdjust(CallbackInfoReturnable<LinkedList<ExtraDamage.DistanceDamagePair>> cir) {
//    }
//}
//}