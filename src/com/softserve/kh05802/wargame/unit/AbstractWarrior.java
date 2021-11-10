package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.equipment.Equipment;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWarrior implements Unit {

  private int health;
  private int attack;

  private int maxHealth;
  private List<Equipment> equipments;

  private Unit behind;

  AbstractWarrior(int health, int attack) {
    this.health = health;
    this.attack = attack;

    this.maxHealth = health;
    this.equipments = new ArrayList<>();
  }

  public int getHealth() {
    return health;
  }

  protected void setHealth(int health) {
    this.health = Math.max(0, health);
  }

  @Override
  public int getAttack() {
    return attack;
  }

  protected void setAttack(int attack) {
    this.attack = Math.max(0, attack);
  }

  @Override
  public Unit getBehind() {
    return behind;
  }

  @Override
  public void setBehind(Unit behind) {
    this.behind = behind;
  }

  @Override
  public boolean isAlive() {
    return health > 0;
  }

  @Override
  public void hits(Unit unit) {
    unit.addHealth(Math.min(0, -unit.getDamage(this)));
    if (getBehind() instanceof Healer) {
      ((Healer) getBehind()).heal(this);
    }
  }

  @Override
  public int getDamage(Unit unit) {
    return Math.min(unit.getAttack(), getHealth());
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    if (!isAlive() || equipment == null) {
      return;
    }
    this.equipments.add(equipment);
    addHealth(equipment.getHealth());
    maxHealth = getHealth();
    addAttack(equipment.getAttack());
  }

  @Override
  public void addHealth(int value) {
    setHealth(getHealth() + value);
  }

  @Override
  public void addAttack(int value) {
    setAttack(getAttack() + value);
  }

  protected int getMaxHealth() {
    return maxHealth;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + getHealth() +
        ", attack=" + getAttack() +
        '}';
  }

}
