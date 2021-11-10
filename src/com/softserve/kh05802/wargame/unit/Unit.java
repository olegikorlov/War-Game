package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface Unit {

  int getAttack();

  Unit getBehind();

  void setBehind(Unit unit);

  boolean isAlive();

  void hits(Unit unit);

  int getDamage(Unit unit);

  void equipWeapon(Equipment equipment);

  void addHealth(int value);

  void addAttack(int value);

}
