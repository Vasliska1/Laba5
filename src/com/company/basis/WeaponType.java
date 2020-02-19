package com.company.basis;

public enum  WeaponType {
    HAMMER(2),
    RIFLE(4),
    MACHINE_GUN(3),
    BAT(1);

    public int power;

    WeaponType(int power) {
        this.power = power;
    }
}
