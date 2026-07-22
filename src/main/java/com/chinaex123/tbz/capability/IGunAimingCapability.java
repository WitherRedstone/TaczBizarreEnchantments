package com.chinaex123.tbz.capability;

/**
 * 枪械瞄准能力接口
 * <p>
 * 定义实体瞄准状态的管理方法
 * 用于跟踪玩家或其他生物是否正在使用枪械进行瞄准
 * 该能力通过 Capability 系统附着在 LivingEntity 上
 */
public interface IGunAimingCapability {

    /**
     * 设置瞄准状态
     *
     * @param isAiming true表示正在瞄准，false表示取消瞄准
     */
    void setAiming(boolean isAiming);

    /**
     * 获取当前瞄准状态
     *
     * @return true表示正在瞄准，false表示未在瞄准
     */
    boolean isAiming();
}