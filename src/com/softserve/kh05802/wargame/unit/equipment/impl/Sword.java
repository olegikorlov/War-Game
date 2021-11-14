package com.softserve.kh05802.wargame.unit.equipment.impl;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Sword extends WeaponDecorator {

  @Override
  public int getHealth() {
    return super.getHealth() + 5;
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 2;
  }

}
