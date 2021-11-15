package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Attacker;
import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class AbstractAttacker extends AbstractUnit implements Attacker {

  private int attack;

  protected AbstractAttacker(int health, int attack) {
    super(health);
    this.attack = attack;
  }

  @Override
  public int getAttack() {
    return attack;
  }

  protected void setAttack(int attack) {
    this.attack = Math.max(0, attack);
  }

  @Override
  public void hits(Unit unit) {
    unit.addHealth(Math.min(0, -unit.getDamageFrom(this)));
    if (getBehind() instanceof HealerImpl) {
      ((HealerImpl) getBehind()).heal(this);
    }
  }

  @Override
  public void addAttack(int value) {
    setAttack(getAttack() + value);
  }

  @Override
  public void equipWeapon(Equipment equipment) {
    super.equipWeapon(equipment);
    addAttack(equipment.getAttack());
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + getHealth() +
        ", attack=" + getAttack() +
        '}';
  }

}
