package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Defender extends Warrior {

  private int defense;

  public Defender() {
    this(60, 3, 2);
  }

  private Defender(int health, int attack, int defense) {
    super(health, attack);
    this.defense = defense;
  }

  public int getDefense() {
    return defense;
  }

  @Override
  public int getDamage(Unit unit) {
    return Math.min(unit.getAttack() - getDefense(), getHealth());
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
        ", attack=" + getAttack() +
        ", defense=" + getDefense() +
        '}';
  }

}
