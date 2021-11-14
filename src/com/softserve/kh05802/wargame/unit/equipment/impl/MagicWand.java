package com.softserve.kh05802.wargame.unit.equipment.impl;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class MagicWand extends WeaponDecorator {

  @Override
  public int getHealth() {
    return super.getHealth() + 30;
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 3;
  }

  @Override
  public int getHealPower() {
    return super.getHealPower() + 3;
  }

}
