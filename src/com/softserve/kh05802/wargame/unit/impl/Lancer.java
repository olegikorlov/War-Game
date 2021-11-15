package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Barricade;
import com.softserve.kh05802.wargame.unit.Unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Lancer extends Warrior {

  public Lancer() {
    super(50, 6);
  }

  @Override
  public void hits(Unit unit) {
    int firstWarriorDamage = unit.getDamageFrom(this);
    super.hits(unit);
    if (unit instanceof Barricade) {
      return;
    }
    Unit unitBehind = unit.getBehind();
    if (unitBehind != null) {
      new ProxyLancer(firstWarriorDamage).hits(unitBehind);
    }
  }

  private static final class ProxyLancer extends Lancer {

    private static final int DAMAGE_DROP = 50;
    private final int damage;

    private ProxyLancer(int damage) {
      this.damage = damage;
    }

    @Override
    public int getAttack() {
      return damage * DAMAGE_DROP / 100;
    }

  }

}
