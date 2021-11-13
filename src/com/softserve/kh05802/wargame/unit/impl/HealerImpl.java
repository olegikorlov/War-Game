package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Healer;
import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class HealerImpl extends Warrior implements Healer {

  private int healPower;

  public HealerImpl() {
    this(60, 0, 2);
  }

  private HealerImpl(int health, int attack, int healPower) {
    super(health, attack);
    this.healPower = healPower;
  }

  @Override
  public int getHealPower() {
    return healPower;
  }

  @Override
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
