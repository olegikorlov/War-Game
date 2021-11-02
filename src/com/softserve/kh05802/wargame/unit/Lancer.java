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
  public void hits(Warrior warrior) {
    int firstWarriorDamage = warrior.getDamage(this);
    warrior.setHealth(warrior.getHealth() - firstWarriorDamage);
    Warrior warriorBehind = warrior.getBehind();
    if (warriorBehind != null) {
      warriorBehind.setHealth(warriorBehind.getHealth() - warriorBehind.getDamage(new WarriorProxy(firstWarriorDamage)));
    }
  }

  private static final class WarriorProxy extends Warrior {

    private final int attack;

    private WarriorProxy(int attack) {
      this.attack = attack;
    }

    @Override
    int getAttack() {
      return attack * DAMAGE_DROP / 100;
    }

  }

}
