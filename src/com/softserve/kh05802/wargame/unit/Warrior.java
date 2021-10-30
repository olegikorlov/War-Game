package com.softserve.kh05802.wargame.unit;

public class Warrior {

    private static final int MAX_HEALTH = 50;

    private int health;
    private final int attack;

    public Warrior() {
        this(MAX_HEALTH, 5);
    }

    protected Warrior(int health, int attack) {
        this.attack = attack;
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    int getHealth() {
        return health;
    }

    int getAttack() {
        return attack;
    }

    void cure(int value) {
        int healthAfterCure = health + value;
        if (healthAfterCure > getMaxHealth()) {
            health = getMaxHealth();
            return;
        }
        health = healthAfterCure;
    }

    int getMaxHealth() {
        return MAX_HEALTH;
    }

    public void hits(Warrior warrior) {
        warrior.health -= warrior.getDamage(this);
    }

    protected int getDamage(Warrior warrior) {
        return warrior.getAttack();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "health=" + health +
            ", attack=" + attack +
            '}';
    }
}
