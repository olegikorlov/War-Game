package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Healer;
import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.UnitFactory;
import com.softserve.kh05802.wargame.unit.impl.Lancer;
import com.softserve.kh05802.wargame.unit.impl.Warlord;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Army implements Iterable<Unit> {

  private final List<Unit> units = new LinkedList<>();

  private boolean isWarlordPresent = false;

  public Army addUnits(Class<? extends Unit> type, int quantity) {
    if (type != Warlord.class) {
      List<Unit> unitList = UnitFactory.generateUnits(type, quantity);
      units.addAll(unitList);
    } else if (!isWarlordPresent) {
      units.add(UnitFactory.generateUnit(type));
      isWarlordPresent = true;
    }
    return this;
  }

  public boolean isAlive() {
    return hasNext();
  }

  public void lineUp() {
    if (units.size() == 1) {
      return;
    }
    for (int i = 0; i < units.size() - 1; i++) {
      units.get(i).setBehind(units.get(i + 1));
    }
  }

  public Unit unitBy(int index) {
    if (index >= units.size()) {
      throw new IndexOutOfBoundsException();
    }
    return units.get(index);
  }

  int size() {
    return units.size();
  }

  public Unit next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return units.get(0);
  }

  public boolean hasNext() {
    return !units.isEmpty();
  }

  public void buryDeadUnits() {
    Iterator<Unit> iterator = iterator();
    while (iterator.hasNext()) {
      if (!iterator.next().isAlive()) {
        iterator.remove();
      }
    }
  }

  public void moveUnits() {
    if (!isWarlordPresent
        || units.size() < 2
        || unitBy(0) instanceof Lancer && unitBy(1) instanceof Healer) {
      return;
    }

    if (!(unitBy(units.size() - 1) instanceof Warlord)) {
      moveWarlordToTheEnd();
    }

    moveLancerOrNotHealerOnFirstPlace();
    moveHealerOnSecondPlace();

    System.out.println(units);
  }

  private void moveHealerOnSecondPlace() {
    if (unitBy(1) instanceof Healer) {
      return;
    }
    for (int fromIndex = 2; fromIndex < units.size() - 1; fromIndex++) {
      if (unitBy(fromIndex) instanceof Healer) {
        insertWithShift(1, fromIndex);
        return;
      }
    }
  }

  private void moveLancerOrNotHealerOnFirstPlace() {
    moveLancersAhead();
    if (unitBy(0) instanceof Lancer || !(unitBy(0) instanceof Healer)) {
      return;
    }

    /**
     * if healer heal the warlord then index have to start from 0 if not from 1
     * in some case with index 0 we can get infinity loop.
     * For example, in case [Healer > Warlord ->X<- Warlord < Healer]
     */
    for (int fromIndex = 1; fromIndex < units.size() - 1; fromIndex++) {
      if (!(unitBy(fromIndex) instanceof Healer)) {
        insertWithShift(0, fromIndex);
        return;
      }
    }
  }

  private void moveWarlordToTheEnd() {
    units.sort((unit1, unit2) -> {
      if (!(unit1 instanceof Warlord) && !(unit2 instanceof Warlord)) {
        return 0;
      }
      if (unit1 instanceof Warlord) {
        return 1;
      }
      return -1;
    });
  }

  private void moveLancersAhead() {
    units.sort((unit1, unit2) -> {
      if (!(unit1 instanceof Lancer) && unit2 instanceof Lancer) {
        return 1;
      } else if (unit1 instanceof Lancer && !(unit2 instanceof Lancer)) {
        return -1;
      } /*else if (!(unit1 instanceof Healer) && unit2 instanceof Healer) {
        return 1;
      } else if (unit1 instanceof Healer && !(unit2 instanceof Healer)) {
        return -1;
      }*/
      return 0;
    });
  }

  private void insertWithShift(int toIndex, int fromIndex) {
    if (fromIndex <= toIndex) {
      throw new IllegalArgumentException("\"fromIndex\" have to be bigger then \"toIndex\"");
    }
    for (int i = fromIndex; i > toIndex; i--) {
      swapUnitsBy(i - 1, i);
    }
  }

  private void swapUnitsBy(int index0, int index1) {
    units.set(index0, units.set(index1, units.get(index0)));
  }

  @Override
  public String toString() {
    return "Army{" + "units=" + units +
        '}';
  }

  @Override
  public Iterator<Unit> iterator() {
    return units.iterator();
  }

}
