package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Lancer extends Warrior {

  private static final int DAMAGE_DROP = 50;

  public Lancer() {
    super(50, 6);
  }

  @Override
  public void hits(Unit unit) {
    int firstWarriorDamage = unit.getDamage(this);
    super.hits(unit);
    Unit unitBehind = unit.getBehind();
    if (unitBehind != null) {
      new ProxyWarrior(firstWarriorDamage).hits(unitBehind);
    }
  }

  private static final class ProxyWarrior extends Warrior {

    private final int attack;

    private ProxyWarrior(int attack) {
      this.attack = attack;
    }

    @Override
    public int getAttack() {
      return attack * DAMAGE_DROP / 100;
    }

  }

}
