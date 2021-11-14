package com.softserve.kh05802.wargame.unit.equipment.impl;

import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class WeaponDecorator implements Equipment {

  private final Equipment equipment;

  WeaponDecorator() {
    this.equipment = Weapon.builder()
        .health(0)
        .attack(0)
        .defense(0)
        .vampirism(0)
        .healPower(0)
        .build();
  }

  @Override
  public int getHealth() {
    return equipment.getHealth();
  }

  @Override
  public int getAttack() {
    return equipment.getAttack();
  }

  @Override
  public int getDefense() {
    return equipment.getDefense();
  }

  @Override
  public int getVampirism() {
    return equipment.getVampirism();
  }

  @Override
  public int getHealPower() {
    return equipment.getHealPower();
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + getHealth() +
        ", attack=" + getAttack() +
        ", defense=" + getDefense() +
        ", vampirism=" + getVampirism() +
        ", healPower=" + getHealPower() +
        '}';
  }

}
