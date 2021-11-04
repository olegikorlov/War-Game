package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Defender extends Warrior {

  private static final int MAX_HEALTH = 60;

  private final int defense;

  public Defender() {
    this(MAX_HEALTH, 3, 2);
  }

  private Defender(int health, int attack, int defense) {
    super(health, attack);
    this.defense = defense;
  }

  @Override
  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

  @Override
  protected int getDamage(Warrior warrior) {
    int damage = warrior.getAttack() - defense;
    return Math.max(damage, 0);
  }
}
