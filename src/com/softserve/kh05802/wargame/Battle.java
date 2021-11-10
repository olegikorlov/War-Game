package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Unit;

import java.util.logging.Logger;

public final class Battle {

  private static final Logger LOGGER = Logger.getLogger(Battle.class.getName());

  private Battle() {
  }

  /**
   * Duel of two units till one is dead
   *
   * @param unit1 this unit starts the battle
   * @param unit2 this unit hits second
   * @return true if the first wins, false otherwise
   */
  public static boolean fight(Unit unit1, Unit unit2) {
    LOGGER.info(getMessage(unit1, unit2));
    while (unit1.isAlive() && unit2.isAlive()) {
      unit1.hits(unit2);
      LOGGER.info(getMessage(unit1, unit2));
      if (unit2.isAlive()) {
        unit2.hits(unit1);
        LOGGER.info(getMessage(unit1, unit2));
      } else {
        return true;
      }
    }
    return unit1.isAlive();
  }

  private static String getMessage(Unit unit1, Unit unit2) {
    Unit behind1 = unit1.getBehind();
    Unit behind2 = unit2.getBehind();
    return String.format("%s%s ->X<- %s%s",
        behind1 == null ? "" : String.format("[%s] < ", behind1),
        unit1,
        unit2,
        behind2 == null ? "" : String.format(" > [%s]", behind2));
  }

  public static boolean fight(Army army1, Army army2) {
    while (army1.hasNext() && army2.hasNext()) {
//      System.out.println("\n" + army1 + "\n" + army2);
      fight(army1.next(), army2.next());
    }
    return army1.isAlive();
  }

}