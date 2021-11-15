package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Attacker;
import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.equipment.Equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class AbstractUnit implements Unit {

  private int health;
  private int maxHealth;
  private List<Equipment> equipments;

  private Unit behind;

  protected AbstractUnit(int health) {
    this.health = health;
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
  public boolean isAlive() {
    return health > 0;
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
  public int getDamageFrom(Attacker attacker) {
    return Math.min(attacker.getAttack(), getHealth());
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    if (!isAlive() || equipment == null) {
      return;
    }
    this.equipments.add(equipment);
    addHealth(equipment.getHealth());
    maxHealth = getHealth();
  }

  @Override
  public void addHealth(int value) {
    setHealth(getHealth() + value);
  }

  protected int getMaxHealth() {
    return maxHealth;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + getHealth() + '}';
  }

}
