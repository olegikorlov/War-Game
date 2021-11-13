package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.Vampire;
import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class VampireImpl extends Warrior implements Vampire {

  private int vampirism;

  public VampireImpl() {
    this(40, 4, 50);
  }

  private VampireImpl(int health, int attack, int vampirism) {
    super(health, attack);
    this.vampirism = vampirism;
  }

  @Override
  public int getVampirism() {
    return vampirism;
  }

  @Override
  public void hits(Unit unit) {
    int damage = unit.getDamageFrom(this);
    super.hits(unit);
    int value = damage * getVampirism() / 100;
    int difference = getMaxHealth() - getHealth();
    if (difference > 0) {
      addHealth(Math.min(value, difference));
    }
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    super.equipWeapon(equipment);
    this.vampirism = Math.max(0, getVampirism() + equipment.getVampirism());
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" +
        "health=" + getHealth() +
        ", attack=" + getAttack() +
        ", vampirism=" + getVampirism() +
        '}';
  }

}
