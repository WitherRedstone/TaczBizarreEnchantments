package com.chinaex123.tbz.capability;

/**
 * 枪械瞄准能力实现类
 * <p>
 * 实现 IGunAimingCapability 接口，管理实体的瞄准状态
 * 用于跟踪玩家或其他生物是否正在使用枪械瞄准
 */
public class GunAimingCapability implements IGunAimingCapability {

    // 瞄准状态标志
    private boolean isAiming = false;

    /**
     * 设置瞄准状态
     *
     * @param isAiming true表示正在瞄准，false表示取消瞄准
     */
    @Override
    public void setAiming(boolean isAiming) {
        this.isAiming = isAiming;
    }

    /**
     * 获取当前瞄准状态
     *
     * @return true表示正在瞄准，false表示未在瞄准
     */
    @Override
    public boolean isAiming() {
        return isAiming;
    }
}