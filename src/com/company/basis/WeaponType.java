package com.company.basis;

import java.io.Serializable;

public enum  WeaponType implements Serializable {


    HAMMER(2),
    RIFLE(4),
    MACHINE_GUN(3),
    BAT(1);

    public int getPower() {
        return power;
    }

    public int power;

    WeaponType(int power) {
        this.power = power;
    }


}
