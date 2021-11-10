package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.Unit;
import com.softserve.kh05802.wargame.unit.UnitFactory;
import com.softserve.kh05802.wargame.unit.Warlord;

import java.util.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Army {

  private final List<Unit> units = new LinkedList<>();

  private boolean isWarlordPresent = false;

  public Army addUnits(Class<? extends Unit> type, int quantity) {
    if (type != Warlord.class) {
      List<Unit> unitList = generateUnits(type, quantity);
      units.addAll(unitList);
    } else if (!isWarlordPresent) {
      units.add(UnitFactory.generateUnit(type));
      isWarlordPresent = true;
    }
    return this;
  }

  private List<Unit> generateUnits(Class<? extends Unit> type, int quantity) {
    List<Unit> result = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      result.add(UnitFactory.generateUnit(type));
    }
    return result;
  }

  public boolean isAlive() {
    return hasNext();
  }

  public Unit unitBy(int index) {
    if (index < units.size()) {
      return units.get(index);
    } else {
      throw new IndexOutOfBoundsException();
    }
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
//    units.indexOf()
//    Unit[] units = (Unit[]) this.units.toArray();

    System.out.println(Arrays.toString(units.toArray()));
  }

  @Override
  public String toString() {
    return "Army{" + "units=" + units +
        '}';
  }

}
