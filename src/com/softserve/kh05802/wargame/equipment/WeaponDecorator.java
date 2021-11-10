package com.softserve.kh05802.wargame.equipment;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
abstract class WeaponDecorator implements Equipment {

  private final Equipment equipment;

  protected WeaponDecorator() {
    this.equipment = new Weapon();
  }

  protected WeaponDecorator(Equipment equipment) {
    this.equipment = equipment;
  }

  @Override
  public int getHealth() {
    return equipment.getHealth();
  }

  @Override
  public int getAttack() {
    return equipment.getAttack();
  }

  @Override
  public int getDefense() {
    return equipment.getDefense();
  }

  @Override
  public int getVampirism() {
    return equipment.getVampirism();
  }

  @Override
  public int getHealPower() {
    return equipment.getHealPower();
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "health=" + getHealth() +
        ", attack=" + getAttack() +
        ", defense=" + getDefense() +
        ", vampirism=" + getVampirism() +
        ", healPower=" + getHealPower() +
        '}';
  }

}
