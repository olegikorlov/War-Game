package com.softserve.kh05802.wargame.unit.equipment.impl;

import com.softserve.kh05802.wargame.unit.equipment.Equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public final class Weapon implements Equipment {

  private final int health;
  private final int attack;
  private final int defense;
  private final int vampirism;
  private final int healPower;

  public Weapon() {
    this(new Builder());
  }

  private Weapon(Builder builder) {
    this.health = builder.health;
    this.attack = builder.attack;
    this.defense = builder.defense;
    this.vampirism = builder.vampirism;
    this.healPower = builder.healPower;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getAttack() {
    return attack;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public int getVampirism() {
    return vampirism;
  }

  @Override
  public int getHealPower() {
    return healPower;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + health +
        ", attack=" + attack +
        ", defense=" + defense +
        ", vampirism=" + vampirism +
        ", healPower=" + healPower +
        '}';
  }

  public static class Builder {

    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healPower;

    public Builder health(int health) {
      this.health = health;
      return this;
    }

    public Builder attack(int attack) {
      this.attack = attack;
      return this;
    }

    public Builder defense(int defense) {
      this.defense = defense;
      return this;
    }

    public Builder vampirism(int vampirism) {
      this.vampirism = vampirism;
      return this;
    }

    public Builder healPower(int healPower) {
      this.healPower = healPower;
      return this;
    }

    public Weapon build() {
      return new Weapon(this);
    }

  }

}
