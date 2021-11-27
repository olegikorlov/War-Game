package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Attacker;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class BarricadeImpl extends AbstractBarricade {

  public BarricadeImpl() {
    this(30, 1);
  }

  private BarricadeImpl(int health, int defense) {
    super(health, defense);
  }

  @Override
  public int getDamageFrom(Attacker attacker) {
    int damage = super.getDamageFrom(attacker);
    int halfOfDamage = damage * 50 / 100;
    attacker.addHealth(Math.min(0, -halfOfDamage));
    return damage;
  }

}
