package com.softserve.kh05802.wargame.unit;

public final class Knight extends Warrior {

    private static final int MAX_HEALTH = 50;

    public Knight() {
        super(MAX_HEALTH, 7);
    }

    @Override
    int getMaxHealth() {
        return MAX_HEALTH;
    }
}
