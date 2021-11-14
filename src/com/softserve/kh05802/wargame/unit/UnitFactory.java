package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.unit.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class UnitFactory {

  private UnitFactory() {
  }

  private static Unit generateUnit(Class<? extends Unit> type) {
    if (type.equals(Knight.class)) {
      return new Knight();
    } else if (type.equals(DefenderImpl.class)) {
      return new DefenderImpl();
    } else if (type.equals(Rookie.class)) {
      return new Rookie();
    } else if (type.equals(VampireImpl.class)) {
      return new VampireImpl();
    } else if (type.equals(Lancer.class)) {
      return new Lancer();
    } else if (type.equals(HealerImpl.class)) {
      return new HealerImpl();
    } else if (type.equals(WarlordImpl.class)) {
      return new WarlordImpl();
    } else if (type.equals(Protector.class)) {
      return new Protector();
    } else if (type.equals(Warrior.class)) {
      return new Warrior();
    }
    throw new IllegalArgumentException("Unknown type: " + type);
  }

  public static List<Unit> generateUnits(Class<? extends Unit> type, int quantity) {
    List<Unit> result = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      result.add(generateUnit(type));
    }
    return result;
  }

}
