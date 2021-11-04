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
    System.out.println(warrior1.getBehind() + " < " + warrior1 + "  " + warrior2 + " > " + warrior2.getBehind());
    while (warrior1.isAlive() && warrior2.isAlive()) {
      warrior1.hits(warrior2);
      System.out.println(warrior1.getBehind() + " < " + warrior1 + "  " + warrior2 + " > " + warrior2.getBehind());
      if (warrior2.isAlive()) {
        warrior2.hits(warrior1);
        System.out.println(warrior1.getBehind() + " < " + warrior1 + "  " + warrior2 + " > " + warrior2.getBehind());
      } else {
        return true;
      }
    }
    return warrior1.isAlive();
  }

  public static boolean fight(Army army1, Army army2) {
    while (army1.hasNext() && army2.hasNext()) {
//      System.out.println("\n" + army1 + "\n" + army2);
      fight(army1.next(), army2.next());
    }
    return army1.isAlive();
  }

}