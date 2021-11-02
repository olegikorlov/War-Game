package com.softserve.kh05802.wargame.unit;

public class Warrior {

  private static final int MAX_HEALTH = 50;

  private final int attack;
  private int health;

  private Warrior behind;

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

  public int getHealth() {
    return health;
  }

  protected void setHealth(int health) {
    this.health = Math.min(health, getMaxHealth());
  }

  int getAttack() {
    return attack;
  }

  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

  public void hits(Warrior warrior) {
    warrior.health -= warrior.getDamage(this);
  }

  protected int getDamage(Warrior warrior) {
    return getDamage(warrior, 100);
  }

  protected int getDamage(Warrior warrior, int percent) {
    return warrior.getAttack() * percent / 100;
  }

  public Warrior getBehind() {
    return behind;
  }

  public void setBehind(Warrior behind) {
    this.behind = behind;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + health +
        ", attack=" + attack +
        '}';
  }
}
