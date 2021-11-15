package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Attacker;
import com.softserve.kh05802.wargame.unit.Defender;
import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class AbstractDefender extends AbstractUnit implements Defender {

  private int defense;

  protected AbstractDefender(int health, int defense) {
    super(health);
    this.defense = defense;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public int getDamageFrom(Attacker attacker) {
    return Math.min(attacker.getAttack() - getDefense(), getHealth());
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    super.equipWeapon(equipment);
    this.defense = Math.max(0, getDefense() + equipment.getDefense());
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" +
        "health=" + getHealth() +
        ", defense=" + getDefense() +
        '}';
  }

}
