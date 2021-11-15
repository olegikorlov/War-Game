package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Healer;
import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.Warlord;
import com.softserve.kh05802.wargame.unit.impl.Lancer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.softserve.kh05802.wargame.unit.UnitFactory.generateUnits;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Army implements Iterable<Unit> {

  private final List<Unit> units = new LinkedList<>();
  private int warlordPosition = -1;

  private boolean isWarlordPresent() {
    return warlordPosition > -1;
  }

  public Army addUnits(Class<? extends Unit> type, int quantity) {
    List<Unit> unitList = generateUnits(type, quantity);
    if (unitList.isEmpty()) {
      return this;
    }
    if (!(unitList.get(0) instanceof Warlord)) {
      units.addAll(unitList);
      return this;
    }
    if (!isWarlordPresent()) {
      units.add(unitList.get(0));
      warlordPosition = getLastIndex();
      return this;
    }
    units.set(warlordPosition, unitList.get(0));
    return this;
  }

  public boolean isAlive() {
    return hasNext();
  }

  public void lineUp() {
    if (size() == 1) {
      return;
    }
    for (int i = 0; i < getLastIndex(); i++) {
      getUnitBy(i).setBehind(getUnitBy(i + 1));
    }
  }

  public Unit getLastUnit() {
    return getUnitBy(getLastIndex());
  }

  private int getLastIndex() {
    return size() - 1;
  }

  public Unit getUnitBy(int index) {
    return units.get(index);
  }

  public int size() {
    return units.size();
  }

  public Unit next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return getUnitBy(0);
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
    if (size() < 2 || !moveWarlordToTheEnd()) {
      return;
    }

    Warlord warlord = (Warlord) getLastUnit();
    warlord.move(this);

    System.out.println(units);
  }

  public Army moveHealerOnSecondPlace() {
    if (getUnitBy(1) instanceof Healer) {
      return this;
    }
    for (int fromIndex = 2; fromIndex < getLastIndex(); fromIndex++) {
      if (getUnitBy(fromIndex) instanceof Healer) {
        insertWithShift(1, fromIndex);
        return this;
      }
    }
    return this;
  }

  /**
   * The method move some lancer or not a healer on first place.
   *
   * @return Army
   */
  public Army moveLancerOrNotHealerOnFirstPlace() {
    moveLancersAhead();
    if (getUnitBy(0) instanceof Lancer || !(getUnitBy(0) instanceof Healer)) {
      return this;
    }

    /*
     * if healer heal the warlord then index have to start from 0 if not from 1
     * in some case with index 0 we can get infinity loop.
     * For example, in case [Healer > Warlord ->X<- Warlord < Healer]
     */
    for (int fromIndex = 1; fromIndex < getLastIndex(); fromIndex++) {
      if (!(getUnitBy(fromIndex) instanceof Healer)) {
        insertWithShift(0, fromIndex);
        return this;
      }
    }
    return this;
  }

  public void applySuperpowerFromWarlord() {
    if (!isWarlordPresent()) {
      return;
    }
    if (!(getLastUnit() instanceof Warlord)) {
      moveWarlordToTheEnd();
    }
    Warlord warlord = (Warlord) getLastUnit();
    warlord.applySuperpower(this);
  }

  public boolean moveWarlordToTheEnd() {
    if (!isWarlordPresent()) {
      return false;
    }
    if (getLastUnit() instanceof Warlord) {
      return true;
    }
    for (int index = 0; index < getLastIndex(); index++) {
      if (getUnitBy(index) instanceof Warlord) {
        insertWithShift(getLastIndex(), index);
        warlordPosition = getLastIndex();
      }
    }
    return getLastUnit() instanceof Warlord;
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
      for (int i = fromIndex; i < toIndex; i++) {
        swapUnitsBy(i, i + 1);
      }
    }
    for (int i = fromIndex; i > toIndex; i--) {
      swapUnitsBy(i - 1, i);
    }
  }

  private void swapUnitsBy(int toIndex, int fromIndex) {
    units.set(toIndex, units.set(fromIndex, getUnitBy(toIndex)));
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
