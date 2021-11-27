package com.softserve.kh05802.wargame.unit;

import com.softserve.kh05802.wargame.Army;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public interface Warlord extends Attacker, Defender {

  void applySuperpower(Army army);

  void move(Army army);

}
