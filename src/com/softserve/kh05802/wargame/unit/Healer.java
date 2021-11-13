package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface Healer {

  int getHealPower();

  void heal(Unit unit);

}
