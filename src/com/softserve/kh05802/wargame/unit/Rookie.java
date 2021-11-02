package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Rookie extends Warrior {

  private static final int MAX_HEALTH = 50;

  public Rookie() {
    super(MAX_HEALTH, 1);
  }

  @Override
  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

}
