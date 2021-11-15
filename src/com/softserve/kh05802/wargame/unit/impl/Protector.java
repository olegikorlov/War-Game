package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.Army;
import com.softserve.kh05802.wargame.unit.equipment.impl.Weapon;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Protector extends AbstractWarlord {

  public Protector() {
    super(100, 3, 2);
  }

  @Override
  public void applySuperpower(Army army) {
    for (int index = 0; index < army.size() - 1; index++) {
      Weapon weapon = Weapon.builder()
          .defense(2)
          .health(10)
          .build();
      army.getUnitBy(index).equipWeapon(weapon);
    }
  }

  @Override
  public void move(Army army) {
    army.moveBarricadeAhead();
  }

}
