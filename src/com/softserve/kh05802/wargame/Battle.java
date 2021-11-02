package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Warrior;

public final class Battle {

  private Battle() {
  }

  /**
   * Duel of two warriors till one is dead
   *
   * @param warrior1 this warrior starts the battle
   * @param warrior2 this warrior hits second
   * @return true if the first wins, false otherwise
   */
  public static boolean fight(Warrior warrior1, Warrior warrior2) {
//    System.out.println(warrior1.getHealth() + "\t" + warrior2.getHealth());
    while (warrior1.isAlive() && warrior2.isAlive()) {
      warrior1.hits(warrior2);
//      System.out.println(warrior1.getHealth() + "\t" + warrior2.getHealth());
      if (warrior2.isAlive()) {
        warrior2.hits(warrior1);
//        System.out.println(warrior1.getHealth() + "\t" + warrior2.getHealth());
      } else {
        return true;
      }
    }
    return warrior1.isAlive();
  }

  public static boolean fight(Army army1, Army army2) {
    while (army1.hasNext() && army2.hasNext()) {
      fight(army1.next(), army2.next());
    }
    return army1.isAlive();
  }

}