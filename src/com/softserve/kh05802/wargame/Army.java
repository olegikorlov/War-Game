package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.UnitFactory;
import com.softserve.kh05802.wargame.unit.Warlord;

import java.util.*;

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
    if (index < units.size()) {
      return units.get(index);
    } else {
      throw new IndexOutOfBoundsException();
    }
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
    if (units.isEmpty()) {
      return false;
    }
    if (!units.get(0).isAlive()) {
      units.remove(0);
      return !units.isEmpty();
    }
    return true;
  }

  public void moveUnits() {
    if (!isWarlordPresent) {
      return;
    }
    System.out.println(Arrays.toString(units.toArray()));
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
