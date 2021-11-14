package com.softserve.kh05802.wargame.unit.impl;

import com.softserve.kh05802.wargame.Army;
import com.softserve.kh05802.wargame.unit.Healer;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class WarlordImpl extends AbstractWarlord {

  public WarlordImpl() {
    super(100, 4, 2);
  }

  @Override
  public void applySuperpower(Army army) {
    // The usual warlord doesn't have any superpower.
  }

  @Override
  public void move(Army army) {
    if (army.unitBy(0) instanceof Lancer
        && army.unitBy(1) instanceof Healer) {
      return;
    }

    army
        .moveLancerOrNotHealerOnFirstPlace()
        .moveHealerOnSecondPlace();

  }

}
