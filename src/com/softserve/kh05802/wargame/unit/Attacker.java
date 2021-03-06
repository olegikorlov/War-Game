package com.softserve.kh05802.wargame.unit;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface Attacker extends Unit {

  int getAttack();

  void hits(Unit unit);

  void addAttack(int value);

}
