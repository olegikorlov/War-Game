package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Unit;

import java.util.Iterator;
import java.util.logging.Logger;

public final class Battle {

  private static final Logger LOGGER = Logger.getLogger(Battle.class.getName());

  private Battle() {
  }

  /**
   * Duel of two units till one is dead
   *
   * @param ally  this unit starts the battle
   * @param enemy this unit hits second
   * @return true if the first wins, false otherwise
   */
  public static boolean fight(Unit ally, Unit enemy) {
    LOGGER.info(getMessage(ally, enemy));
    while (ally.isAlive() && enemy.isAlive()) {
      ally.hits(enemy);
      LOGGER.info(getMessage(ally, enemy));
      if (enemy.isAlive()) {
        enemy.hits(ally);
        LOGGER.info(getMessage(ally, enemy));
      } else {
        return true;
      }
    }
    return ally.isAlive();
  }

  private static String getMessage(Unit ally, Unit enemy) {
    Unit allyBehind = ally.getBehind();
    Unit enemyBehind = enemy.getBehind();
    return String.format("%s%s ->X<- %s%s",
        allyBehind == null ? "" : String.format("[%s] < ", allyBehind),
        ally,
        enemy,
        enemyBehind == null ? "" : String.format(" > [%s]", enemyBehind));
  }

  /**
   * Duel of two armies till one of them wins.
   * The fight is going with line-up formation.
   *
   * @param allyArmy  this army starts the battle
   * @param enemyArmy this army hits second
   * @return true if the first army is winning, false otherwise
   */
  public static boolean fight(Army allyArmy, Army enemyArmy) {
    allyArmy.moveWarlordToTheEnd();
    buryDeadAndMoveUnitsAndLineUp(allyArmy);
    allyArmy.applySuperpowerFromWarlord();
    enemyArmy.moveWarlordToTheEnd();
    buryDeadAndMoveUnitsAndLineUp(enemyArmy);
    enemyArmy.applySuperpowerFromWarlord();

    while (allyArmy.hasNext() && enemyArmy.hasNext()) {
      boolean result = fight(allyArmy.next(), enemyArmy.next());
      if (!result) {
        buryDeadAndMoveUnitsAndLineUp(allyArmy);
      } else {
        buryDeadAndMoveUnitsAndLineUp(enemyArmy);
      }
    }
    return allyArmy.isAlive();
  }

  private static void buryDeadAndMoveUnitsAndLineUp(Army army) {
    army.buryDeadUnits();
    army.moveUnits();
    army.lineUp();
  }

  /**
   * Duel of two armies till one of them wins.
   * The fight is going with frontal formation.
   *
   * @param allyArmy  this army starts the battle
   * @param enemyArmy this army hits second
   * @return true if the first army is winning, false otherwise
   */
  public static boolean straightFight(Army allyArmy, Army enemyArmy) {
    moveWarlordToTheEndAndBuryDeadAndMoveUnits(allyArmy);
    moveWarlordToTheEndAndBuryDeadAndMoveUnits(enemyArmy);
    while (true) {
      if (!allyArmy.isAlive() && enemyArmy.isAlive()) {
        return false;
      }
      if (allyArmy.isAlive() && !enemyArmy.isAlive()) {
        return true;
      }
      Iterator<Unit> armyOneIterator = allyArmy.iterator();
      Iterator<Unit> armyTwoIterator = enemyArmy.iterator();
      while (armyOneIterator.hasNext() && armyTwoIterator.hasNext()) {
        boolean isUnitOfArmyOneWinner = fight(armyOneIterator.next(), armyTwoIterator.next());
        if (isUnitOfArmyOneWinner) {
          armyTwoIterator.remove();
          enemyArmy.moveUnits();
        } else {
          armyOneIterator.remove();
          allyArmy.moveUnits();
        }
      }
      LOGGER.info(allyArmy.toString());
      LOGGER.info(enemyArmy.toString());
    }

  }

  private static void moveWarlordToTheEndAndBuryDeadAndMoveUnits(Army army) {
    army.moveWarlordToTheEnd();
    army.buryDeadUnits();
    army.moveUnits();
  }

}