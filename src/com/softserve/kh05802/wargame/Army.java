package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.UnitFactory;
import com.softserve.kh05802.wargame.unit.Warrior;

import java.util.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Army {

  private final Deque<Warrior> warriors = new LinkedList<>();

  public Army addUnits(Class<? extends Warrior> type, int quantity) {
    List<Warrior> unit = generateUnits(type, quantity);
    warriors.addAll(unit);
    return this;
  }

  private List<Warrior> generateUnits(Class<? extends Warrior> type, int quantity) {
    List<Warrior> result = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      result.add(UnitFactory.generateUnit(type));
    }
    return result;
  }

  Warrior next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return warriors.peek();
  }

  boolean hasNext() {
    if (warriors.isEmpty()) {
      return false;
    }
    if (!warriors.peek().isAlive()) {
      warriors.pop();
      return !warriors.isEmpty();
    }
    return true;
  }

  public boolean isAlive() {
    return hasNext();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Army{");
    sb.append("warriors=").append(warriors);
    sb.append('}');
    return sb.toString();
  }

}
