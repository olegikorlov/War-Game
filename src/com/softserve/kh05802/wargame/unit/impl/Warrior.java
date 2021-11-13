package com.softserve.kh05802.wargame.unit.impl;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class Warrior extends AbstractWarrior {

  public Warrior() {
    this(50, 5);
  }

  protected Warrior(int health, int attack) {
    super(health, attack);
  }

}
