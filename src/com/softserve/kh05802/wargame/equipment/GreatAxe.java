package com.softserve.kh05802.wargame.equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class GreatAxe extends WeaponDecorator {

  public GreatAxe() {
  }

  public GreatAxe(Equipment weapon) {
    super(weapon);
  }

  @Override
  public int getHealth() {
    return super.getHealth() - 15;
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 5;
  }

  @Override
  public int getDefense() {
    return super.getDefense() - 2;
  }

  @Override
  public int getVampirism() {
    return super.getVampirism() + 10;
  }

}