package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Healer extends Warrior {

  private int healPower;

  public Healer() {
    this(60, 0, 2);
  }

  private Healer(int health, int attack, int healPower) {
    super(health, attack);
    this.healPower = healPower;
  }

  public int getHealPower() {
    return healPower;
  }

  public void heal(Unit unit) {
    if (unit.isAlive()) {
      unit.addHealth(getHealPower());
    }
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    super.equipWeapon(equipment);
    this.healPower = Math.max(0, getHealPower() + equipment.getHealPower());
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" +
        "health=" + getHealth() +
        ", attack=" + getAttack() +
        ", healPower=" + getHealPower() +
        '}';
  }

}
