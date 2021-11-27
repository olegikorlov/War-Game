package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Barricade;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class AbstractBarricade extends AbstractDefender implements Barricade {

  protected AbstractBarricade(int health, int defense) {
    super(health, defense);
  }

}
