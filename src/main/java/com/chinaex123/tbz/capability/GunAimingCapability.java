package com.chinaex123.tbz.capability;

public class GunAimingCapability implements IGunAimingCapability {
    private boolean isAiming = false;

    @Override
    public void setAiming(boolean isAiming) {
        this.isAiming = isAiming;
    }

    @Override
    public boolean isAiming() {
        return isAiming;
    }
}