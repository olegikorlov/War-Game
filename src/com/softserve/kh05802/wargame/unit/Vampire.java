package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Vampire extends Warrior {

  private int vampirism;

  public Vampire() {
    this(40, 4, 50);
  }

  private Vampire(int health, int attack, int vampirism) {
    super(health, attack);
    this.vampirism = vampirism;
  }

  public int getVampirism() {
    return vampirism;
  }

  @Override
  public void hits(Unit unit) {
    int damage = unit.getDamage(this);
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
