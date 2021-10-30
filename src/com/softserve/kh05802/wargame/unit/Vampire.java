package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Vampire extends Warrior {

  private static final int MAX_HEALTH = 40;

  private final int vampirism;

  public Vampire() {
    this(MAX_HEALTH, 4, 50);
  }

  private Vampire(int health, int attack, int vampirism) {
    super(health, attack);
    this.vampirism = vampirism;
  }

  @Override
  public void hits(Warrior warrior) {
    int healthBefore = warrior.getHealth();
    super.hits(warrior);
    int healthAfter = warrior.getHealth();
    int damage = healthBefore - healthAfter;
    int cureValue = damage * vampirism / 100;
    this.cure(cureValue);
  }

  @Override
  int getMaxHealth() {
    return MAX_HEALTH;
  }

}
