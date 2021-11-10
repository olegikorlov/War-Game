package com.softserve.kh05802.wargame.equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class MagicWand extends WeaponDecorator {

  public MagicWand() {
  }

  public MagicWand(Equipment weapon) {
    super(weapon);
  }

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
