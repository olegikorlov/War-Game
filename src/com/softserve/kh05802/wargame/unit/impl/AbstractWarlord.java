package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.unit.Warlord;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class AbstractWarlord extends AbstractAttackerDefender implements Warlord {

  protected AbstractWarlord(int health, int attack, int defense) {
    super(health, attack, defense);
  }

}
