package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class UnitFactory {

  private UnitFactory() {
  }

  public static Warrior generateUnit(Class<? extends Warrior> type) {
    if (type.equals(Knight.class)) {
      return new Knight();
    } else if (type.equals(Defender.class)) {
      return new Defender();
    } else if (type.equals(Warrior.class)) {
      return new Warrior();
    }
    throw new IllegalArgumentException("Unknown type: " + type);
  }


}
