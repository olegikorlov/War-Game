package com.softserve.kh05802.wargame.unit;

public class Warrior extends AbstractWarrior {

  public Warrior() {
    this(50, 5);
  }

  protected Warrior(int health, int attack) {
    super(health, attack);
  }

}
