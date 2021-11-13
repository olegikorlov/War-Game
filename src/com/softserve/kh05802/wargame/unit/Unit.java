package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface Unit extends Attacker {

  boolean isAlive();

  Unit getBehind();

  void setBehind(Unit unit);

  int getDamageFrom(Attacker attacker);

  void equipWeapon(Equipment equipment);

  void addHealth(int value);

  void addAttack(int value);

}
