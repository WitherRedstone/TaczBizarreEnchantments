package com.chinaex123.tbz.utils;

import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.resource.index.CommonGunIndex;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 枪械类型判断工具类
 * <p>
 * 提供枪械分类相关的辅助方法
 */
public class GunTypeHelper {

    /**
     * 判断指定物品是否为霰弹枪
     *
     * @param itemStack 要检查的物品堆
     * @return true表示是霰弹枪，false表示不是或无法判断
     */
    public static boolean isShotgun(ItemStack itemStack) {
        // 检查物品是否实现了IGun接口
        if (!(itemStack.getItem() instanceof IGun iGun)) {
            return false;
        }

        // 获取枪械ID
        ResourceLocation gunId = iGun.getGunId(itemStack);

        // 获取枪械数据索引
        Optional<CommonGunIndex> gunIndexOpt = TimelessAPI.getCommonGunIndex(gunId);
        if (gunIndexOpt.isEmpty()) {
            return false;
        }

        // 获取武器类型并判断是否为霰弹枪
        String weaponType = gunIndexOpt.get().getType();
        return "shotgun".equalsIgnoreCase(weaponType);
    }
}