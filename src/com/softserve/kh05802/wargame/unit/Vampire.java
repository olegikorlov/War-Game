package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Vampire extends Warrior {

  private static final int MAX_HEALTH = 40;
  private static final int VAMPIRISM = 50;

  public Vampire() {
    super(MAX_HEALTH, 4);
  }

  private void cure(int value) {
    setHealth(getHealth() + value);
  }

  @Override
  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

  @Override
  public void hits(Warrior warrior) {
    int healthBefore = warrior.getHealth();
    super.hits(warrior);
    int damage = healthBefore - warrior.getHealth();
    int cureValue = damage * VAMPIRISM / 100;
    cure(cureValue);
  }

}
