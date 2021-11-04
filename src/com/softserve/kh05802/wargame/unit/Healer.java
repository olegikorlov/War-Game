package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Healer extends Warrior {

  private static final int MAX_HEALTH = 60;
  private static final int HEAL_VALUE = 2;

  public Healer() {
    super(MAX_HEALTH, 0);
  }

  public void heal(Warrior warrior) {
    if (warrior.isAlive()) {
      warrior.setHealth(warrior.getHealth() + HEAL_VALUE);
    }
  }

  @Override
  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

}
