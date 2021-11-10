package com.softserve.kh05802.wargame.equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Shield extends WeaponDecorator {

  public Shield() {
  }

  public Shield(Equipment weapon) {
    super(weapon);
  }

  @Override
  public int getHealth() {
    return super.getHealth() + 20;
  }

  @Override
  public int getAttack() {
    return super.getAttack() - 1;
  }

  @Override
  public int getDefense() {
    return super.getDefense() + 2;
  }

}
