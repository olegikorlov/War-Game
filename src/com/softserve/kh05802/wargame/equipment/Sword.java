package com.softserve.kh05802.wargame.equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Sword extends WeaponDecorator {

  public Sword() {
  }

  public Sword(Equipment weapon) {
    super(weapon);
  }

  @Override
  public int getHealth() {
    return super.getHealth() + 5;
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 2;
  }

}
