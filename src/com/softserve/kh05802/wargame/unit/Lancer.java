package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Lancer extends Warrior {

  private static final int MAX_HEALTH = 50;
  private static final int DAMAGE_DROP = 50;

  public Lancer() {
    super(MAX_HEALTH, 6);
  }

  @Override
  protected int getMaxHealth() {
    return MAX_HEALTH;
  }

  @Override
  public void hits(Warrior warrior) {
    int healthBefore = warrior.getHealth();
    super.hits(warrior);
    int firstWarriorDamage = healthBefore - warrior.getHealth();
    Warrior warriorBehind = warrior.getBehind();
    if (warriorBehind != null) {
      new ProxyWarrior(firstWarriorDamage).hits(warriorBehind);
    }
  }

  private static final class ProxyWarrior extends Warrior {

    private final int attack;

    private ProxyWarrior(int attack) {
      this.attack = attack;
    }

    @Override
    int getAttack() {
      return attack * DAMAGE_DROP / 100;
    }

  }

}
