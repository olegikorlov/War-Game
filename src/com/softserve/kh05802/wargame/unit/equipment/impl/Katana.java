package com.softserve.kh05802.wargame.unit.equipment.impl;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Katana extends WeaponDecorator {

  @Override
  public int getHealth() {
    return super.getHealth() - 20;
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 6;
  }

  @Override
  public int getDefense() {
    return super.getDefense() - 5;
  }

  @Override
  public int getVampirism() {
    return super.getVampirism() + 50;
  }

}
