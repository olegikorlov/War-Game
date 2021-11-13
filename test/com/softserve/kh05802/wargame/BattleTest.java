package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.equipment.Equipment;
import com.softserve.kh05802.wargame.unit.equipment.impl.*;
import com.softserve.kh05802.wargame.unit.impl.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class BattleTest {

  @Test
  @Order(1)
  @DisplayName("1. Fight")
  void fight1() {
    // arrange
    Warrior carl = new Warrior();
    Warrior jim = new Knight();

    // act
    boolean result = Battle.fight(carl, jim);

    // assert
    assertFalse(result);
  }

  @Test
  @Order(2)
  @DisplayName("2. Fight")
  void fight2() {
    Warrior ramon = new Knight();
    Warrior slevin = new Warrior();

    boolean result = Battle.fight(ramon, slevin);

    assertTrue(result);
  }

  @Test
  @Order(3)
  @DisplayName("3. Fight")
  void fight3() {
    Warrior bob = new Warrior();
    Warrior mars = new Warrior();

    Battle.fight(bob, mars);

    assertTrue(bob.isAlive());
  }

  @Test
  @Order(4)
  @DisplayName("4. Fight")
  void fight4() {
    Warrior zeus = new Knight();
    Warrior godKiller = new Warrior();

    Battle.fight(zeus, godKiller);

    assertTrue(zeus.isAlive());
  }

  @Test
  @Order(5)
  @DisplayName("5. Fight")
  void fight5() {
    Warrior husband = new Warrior();
    Warrior wife = new Warrior();

    Battle.fight(husband, wife);

    assertFalse(wife.isAlive());
  }

  @Test
  @Order(6)
  @DisplayName("6. Fight")
  void fight6() {
    Warrior dragon = new Warrior();
    Warrior knight = new Knight();

    Battle.fight(dragon, knight);

    assertTrue(knight.isAlive());
  }

  @Test
  @Order(7)
  @DisplayName("7. Fight")
  void fight7() {
    Warrior unit1 = new Warrior();
    Warrior unit2 = new Knight();
    Warrior unit3 = new Warrior();

    Battle.fight(unit1, unit2);
    boolean result = Battle.fight(unit2, unit3);

    assertFalse(result);
  }

  @Test
  @Order(8)
  @DisplayName("8. Fight")
  void fight8() {
    Warrior unit1 = new DefenderImpl();
    Warrior unit2 = new Rookie();

    Battle.fight(unit1, unit2);

    assertEquals(60, unit1.getHealth());
  }

  @Test
  @Order(9)
  @DisplayName("9. Fight")
  void fight9() {
    Warrior unit1 = new DefenderImpl();
    Warrior unit2 = new Rookie();
    Warrior unit3 = new Warrior();

    Battle.fight(unit1, unit2);
    boolean result = Battle.fight(unit1, unit3);

    assertTrue(result);
  }

  @Test
  @Order(10)
  @DisplayName("1. Battle")
  void battle1() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 1);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 2);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(11)
  @DisplayName("2. Battle")
  void battle2() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 2);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 3);
    boolean res = Battle.fight(army1, army2);
    assertFalse(res);
  }

  @Test
  @Order(12)
  @DisplayName("3. Battle")
  void battle3() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 5);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 7);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(13)
  @DisplayName("4. Battle")
  void battle4() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 20);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 21);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(14)
  @DisplayName("5. Battle")
  void battle5() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 10);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 11);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(15)
  @DisplayName("6. Battle")
  void battle6() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 11);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 7);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(16)
  @DisplayName("7. Battle")
  void battle7() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 5)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(DefenderImpl.class, 5);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(17)
  @DisplayName("8. Battle")
  void battle8() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 5)
        .addUnits(Warrior.class, 20);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 21)
        .addUnits(DefenderImpl.class, 4);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(18)
  @DisplayName("9. Battle")
  void battle9() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 10)
        .addUnits(DefenderImpl.class, 5);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 5);
    army1.addUnits(DefenderImpl.class, 10);

    boolean res = Battle.fight(army1, army2);
    assertTrue(res);
  }

  @Test
  @Order(19)
  @DisplayName("10. Battle")
  void battle10() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 2)
        .addUnits(Warrior.class, 1)
        .addUnits(DefenderImpl.class, 1);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 5);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(20)
  @DisplayName("11. Battle")
  void battle11() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 5)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Warrior.class, 7);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 6)
        .addUnits(DefenderImpl.class, 6)
        .addUnits(VampireImpl.class, 6);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(21)
  @DisplayName("12. Battle")
  void battle12() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 2)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 4);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 3);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(22)
  @DisplayName("13. Battle")
  void battle13() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 11)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 4);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 13);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(23)
  @DisplayName("14. Battle")
  void battle14() {
    Army army1 = new Army();
    army1.addUnits(DefenderImpl.class, 9)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 8);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 13);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(24)
  @DisplayName("15. Battle")
  void battle15() {
    Army army1 = new Army().addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 2)
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 6);
    Army army2 = new Army().addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 5);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(25)
  @DisplayName("16. Battle")
  void battle16() {
    Army army1 = new Army().addUnits(Lancer.class, 7)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 2);
    Army army2 = new Army().addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 4);

    boolean res = Battle.fight(army1, army2);
    assertTrue(res);

  }

  @Test
  @Order(26)
  @DisplayName("17. Battle")
  void battle17() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 7)
        .addUnits(VampireImpl.class, 3)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(DefenderImpl.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 4);

    boolean res = Battle.fight(army1, army2);
    assertTrue(res);

  }

  @Test
  @Order(27)
  @DisplayName("18. Battle")
  void battle18() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 1)
        .addUnits(Warrior.class, 3)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Knight.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 4);

    boolean res = Battle.fight(army1, army2);
    assertFalse(res);

  }

  @Test
  @Order(28)
  @DisplayName("19. Battle")
  void battle19() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 5)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 5);
    assertFalse(Battle.straightFight(army1, army2));
  }

  @Test
  @Order(29)
  @DisplayName("20. Battle")
  void battle20() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 7)
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 4);
    assertTrue(Battle.straightFight(army1, army2));
  }

  @Test
  @Order(30)
  @DisplayName("21. Battle")
  @Disabled
  void battle21() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 7)
        .addUnits(VampireImpl.class, 3)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(DefenderImpl.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(VampireImpl.class, 6)
        .addUnits(Lancer.class, 4);
    assertFalse(Battle.straightFight(army1, army2));
  }

  @Test
  @Order(31)
  @DisplayName("22. Battle")
  void battle22() {
    Army army1 = new Army()
        .addUnits(Lancer.class, 4)
        .addUnits(Warrior.class, 3)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Knight.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(DefenderImpl.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(VampireImpl.class, 2)
        .addUnits(Lancer.class, 4);
    assertTrue(Battle.straightFight(army1, army2));
  }

  @Test
  @Order(32)
  @DisplayName("23. Battle")
  void battle23() {
    Army army1 = new Army()
        .addUnits(Warlord.class, 1)
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 2)
        .addUnits(HealerImpl.class, 2);
    Army army2 = new Army()
        .addUnits(Warlord.class, 1)
        .addUnits(VampireImpl.class, 1)
        .addUnits(HealerImpl.class, 2)
        .addUnits(Knight.class, 2);
    army1.moveUnits();
    army2.moveUnits();
    assertTrue(Battle.fight(army1, army2));
  }

  @Test
  @Order(33)
  @DisplayName("24. Battle")
  void battle24() {
    Army army1 = new Army()
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 2)
        .addUnits(DefenderImpl.class, 1)
        .addUnits(Warlord.class, 3);
    Army army2 = new Army()
        .addUnits(Warlord.class, 2)
        .addUnits(VampireImpl.class, 1)
        .addUnits(HealerImpl.class, 5)
        .addUnits(Knight.class, 2);
    army1.moveUnits();
    army2.moveUnits();
    assertFalse(Battle.fight(army1, army2));
  }

  @Test
  @Order(34)
  @DisplayName("25. Battle")
  void battle25() {
    Army army1 = new Army()
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 3)
        .addUnits(DefenderImpl.class, 1)
        .addUnits(Warlord.class, 4);
    Army army2 = new Army()
        .addUnits(Warlord.class, 1)
        .addUnits(VampireImpl.class, 1)
        .addUnits(Rookie.class, 1)
        .addUnits(Knight.class, 1);
    army1.unitBy(0).equipWeapon(new Sword());
    army2.unitBy(0).equipWeapon(new Shield());
    army1.moveUnits();
    army2.moveUnits();
    assertTrue(Battle.fight(army1, army2));
  }

  @Test
  @Order(35)
  @DisplayName("26. Battle")
  void battle26() {
    Army army1 = new Army()
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 3)
        .addUnits(DefenderImpl.class, 1)
        .addUnits(Warlord.class, 1);
    Army army2 = new Army()
        .addUnits(Warlord.class, 5)
        .addUnits(VampireImpl.class, 1)
        .addUnits(Rookie.class, 1)
        .addUnits(Knight.class, 1);
    army1.unitBy(0).equipWeapon(new Sword());
    army2.unitBy(0).equipWeapon(new Shield());
    army1.moveUnits();
    army2.moveUnits();
    var res = Battle.straightFight(army1, army2);
    assertFalse(res);
  }

  @Test
  @Order(36)
  @DisplayName("1. Weapon")
  void weapon1() {
    Warrior unit1 = new Warrior();
    Warrior unit2 = new VampireImpl();
    Equipment weapon1 = Weapon.builder()
        .health(-10)
        .attack(5)
        .defense(0)
        .vampirism(40)
        .healPower(0)
        .build();
    Equipment weapon2 = new Sword();
    unit1.equipWeapon(weapon1);
    unit2.equipWeapon(weapon2);
    assertTrue(Battle.fight(unit1, unit2));
  }

  @Test
  @Order(37)
  @DisplayName("2. Weapon")
  void weapon2() {
    Warrior unit1 = new DefenderImpl();
    Warrior unit2 = new Lancer();
    Equipment weapon1 = new Shield();
    Equipment weapon2 = new GreatAxe();
    unit1.equipWeapon(weapon1);
    unit2.equipWeapon(weapon2);
    assertFalse(Battle.fight(unit1, unit2));
  }

  @Test
  @Order(38)
  @DisplayName("3. Weapon")
  void weapon3() {
    Warrior unit1 = new HealerImpl();
    Warrior unit2 = new Knight();
    Equipment weapon1 = new MagicWand();
    Equipment weapon2 = new Katana();
    unit1.equipWeapon(weapon1);
    unit2.equipWeapon(weapon2);
    assertFalse(Battle.fight(unit1, unit2));
  }

  @Test
  @Order(39)
  @DisplayName("4. Weapon")
  void weapon4() {
    Warrior unit1 = new DefenderImpl();
    Warrior unit2 = new VampireImpl();
    Equipment weapon1 = new Shield();
    Equipment weapon2 = new MagicWand();
    Equipment weapon3 = new Shield();
    Equipment weapon4 = new Katana();
    unit1.equipWeapon(weapon1);
    unit1.equipWeapon(weapon2);
    unit2.equipWeapon(weapon3);
    unit2.equipWeapon(weapon4);
    assertFalse(Battle.fight(unit1, unit2));
  }

  @Test
  @Order(40)
  @DisplayName("5. Weapon")
  void weapon5() {
    Equipment weapon1 = new MagicWand();
    Equipment weapon2 = new GreatAxe();

    Army myArmy = new Army()
        .addUnits(Knight.class, 1)
        .addUnits(Lancer.class, 1);
    Army enemyArmy = new Army()
        .addUnits(VampireImpl.class, 1)
        .addUnits(HealerImpl.class, 1);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon2);

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(41)
  @DisplayName("6. Weapon")
  void weapon6() {
    Equipment weapon1 = new Sword();
    Equipment weapon2 = new GreatAxe();

    Army myArmy = new Army()
        .addUnits(DefenderImpl.class, 1)
        .addUnits(Warrior.class, 1);
    Army enemyArmy = new Army()
        .addUnits(Knight.class, 1)
        .addUnits(HealerImpl.class, 1);

    myArmy.unitBy(0).equipWeapon(weapon2);
    myArmy.unitBy(1).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon1);

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(42)
  @DisplayName("7. Weapon")
  void weapon7() {
    Equipment weapon1 = new Katana();
    Equipment weapon2 = new Shield();

    Army myArmy = new Army()
        .addUnits(DefenderImpl.class, 2);
    Army enemyArmy = new Army()
        .addUnits(Knight.class, 1)
        .addUnits(VampireImpl.class, 1);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon1);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon1);

    assertFalse(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(43)
  @DisplayName("8. Weapon")
  void weapon8() {
    Equipment weapon1 = Weapon.builder()
        .health(-20)
        .attack(6)
        .defense(1)
        .vampirism(40)
        .healPower(-2)
        .build();
    Equipment weapon2 = Weapon.builder()
        .health(20)
        .attack(-2)
        .defense(2)
        .vampirism(-55)
        .healPower(3)
        .build();

    Army myArmy = new Army()
        .addUnits(Knight.class, 3);
    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(DefenderImpl.class, 2);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon1);
    myArmy.unitBy(2).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon2);
    enemyArmy.unitBy(2).equipWeapon(weapon2);

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(44)
  @DisplayName("9. Weapon")
  void weapon9() {
    Equipment weapon1 = Weapon.builder()
        .health(-20)
        .attack(1)
        .defense(1)
        .vampirism(40)
        .healPower(-2)
        .build();
    Equipment weapon2 = Weapon.builder()
        .health(20)
        .attack(2)
        .defense(2)
        .vampirism(-55)
        .healPower(3)
        .build();

    Army myArmy = new Army()
        .addUnits(VampireImpl.class, 3);
    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(DefenderImpl.class, 2);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon1);
    myArmy.unitBy(2).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon2);
    enemyArmy.unitBy(2).equipWeapon(weapon2);

    assertFalse(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(45)
  @DisplayName("10. Weapon")
  void weapon10() {
    Equipment weapon1 = new Katana();
    Equipment weapon2 = new Shield();

    Army myArmy = new Army()
        .addUnits(VampireImpl.class, 2)
        .addUnits(Rookie.class, 2);
    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(DefenderImpl.class, 2);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon1);
    myArmy.unitBy(2).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon2);
    enemyArmy.unitBy(2).equipWeapon(weapon2);

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(46)
  @DisplayName("11. Weapon")
  void weapon11() {
    Equipment weapon1 = new Sword();
    Equipment weapon2 = new GreatAxe();

    Army myArmy = new Army()
        .addUnits(VampireImpl.class, 3);
    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(DefenderImpl.class, 1);

    myArmy.unitBy(0).equipWeapon(weapon2);
    myArmy.unitBy(1).equipWeapon(weapon2);
    myArmy.unitBy(2).equipWeapon(weapon2);
    enemyArmy.unitBy(0).equipWeapon(weapon1);
    enemyArmy.unitBy(1).equipWeapon(weapon1);

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(47)
  @DisplayName("12. Weapon")
  void weapon12() {
    Equipment weapon1 = new Katana();
    Equipment weapon2 = new MagicWand();

    Army myArmy = new Army()
        .addUnits(Rookie.class, 3);
    Army enemyArmy = new Army()
        .addUnits(DefenderImpl.class, 1)
        .addUnits(HealerImpl.class, 1);

    myArmy.unitBy(0).equipWeapon(weapon1);
    myArmy.unitBy(1).equipWeapon(weapon1);
    myArmy.unitBy(2).equipWeapon(weapon1);
    enemyArmy.unitBy(0).equipWeapon(weapon2);
    enemyArmy.unitBy(1).equipWeapon(weapon2);

    assertFalse(Battle.fight(myArmy, enemyArmy));
  }

  @Test
  @Order(48)
  @DisplayName("Healer")
  void healer() {
    Warrior chuck = new Warrior();
    Warrior bruce = new Warrior();
    Warrior carl = new Knight();
    Warrior dave = new Warrior();
    Warrior mark = new Warrior();
    Warrior bob = new DefenderImpl();
    Warrior mike = new Knight();
    Warrior rog = new Warrior();
    Warrior lancelot = new DefenderImpl();
    Warrior eric = new VampireImpl();
    Warrior adam = new VampireImpl();
    Warrior richard = new DefenderImpl();
    Warrior ogre = new Warrior();
    Warrior freelancer = new Lancer();
    Warrior vampire = new VampireImpl();
    HealerImpl priest = new HealerImpl();

    assertTrue(Battle.fight(chuck, bruce));
    assertFalse(Battle.fight(dave, carl));
    assertTrue(chuck.isAlive());
    assertFalse(bruce.isAlive());
    assertTrue(carl.isAlive());
    assertFalse(dave.isAlive());
    assertFalse(Battle.fight(carl, mark));
    assertFalse(carl.isAlive());
    assertFalse(Battle.fight(bob, mike));
    assertTrue(Battle.fight(lancelot, rog));
    assertFalse(Battle.fight(eric, richard));
    assertTrue(Battle.fight(ogre, adam));
    assertTrue(Battle.fight(freelancer, vampire));
    assertTrue(freelancer.isAlive());

    assertEquals(14, freelancer.getHealth());
    priest.heal(freelancer);
    assertEquals(16, freelancer.getHealth());

    Army myArmy = new Army()
        .addUnits(DefenderImpl.class, 2)
        .addUnits(HealerImpl.class, 1)
        .addUnits(VampireImpl.class, 2)
        .addUnits(Lancer.class, 2)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Warrior.class, 1);

    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 4)
        .addUnits(HealerImpl.class, 1)
        .addUnits(DefenderImpl.class, 2)
        .addUnits(VampireImpl.class, 3)
        .addUnits(HealerImpl.class, 1);

    assertFalse(Battle.fight(myArmy, enemyArmy));

    Army army3 = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(Lancer.class, 1)
        .addUnits(HealerImpl.class, 1)
        .addUnits(DefenderImpl.class, 2);

    Army army4 = new Army()
        .addUnits(VampireImpl.class, 3)
        .addUnits(Warrior.class, 1)
        .addUnits(HealerImpl.class, 1)
        .addUnits(Lancer.class, 2);

    boolean result = Battle.fight(army3, army4);
    assertTrue(result);
  }

  @Test
  @Order(49)
  @DisplayName("Weapon")
  void weapon() {
    Warrior ogre = new Warrior();
    Warrior lancelot = new Knight();
    DefenderImpl richard = new DefenderImpl();
    VampireImpl eric = new VampireImpl();
    Warrior freelancer = new Lancer();
    HealerImpl priest = new HealerImpl();

    Equipment sword = new Sword();
    Equipment shield = new Shield();
    Equipment axe = new GreatAxe();
    Equipment katana = new Katana();
    Equipment wand = new MagicWand();
    Equipment superWeapon = Weapon.builder()
        .health(50)
        .attack(10)
        .defense(5)
        .vampirism(150)
        .healPower(8)
        .build();

    ogre.equipWeapon(sword);
    ogre.equipWeapon(shield);
    ogre.equipWeapon(superWeapon);
    lancelot.equipWeapon(superWeapon);
    richard.equipWeapon(shield);
    eric.equipWeapon(superWeapon);
    freelancer.equipWeapon(axe);
    freelancer.equipWeapon(katana);
    priest.equipWeapon(wand);
    priest.equipWeapon(shield);

    assertEquals(125, ogre.getHealth());
    assertEquals(17, lancelot.getAttack());
    assertEquals(4, richard.getDefense());
    assertEquals(200, eric.getVampirism());
    assertEquals(15, freelancer.getHealth());
    assertEquals(5, priest.getHealPower());

    assertFalse(Battle.fight(ogre, eric));
    assertFalse(Battle.fight(priest, richard));
    assertTrue(Battle.fight(lancelot, freelancer));

    Army myArmy = new Army()
        .addUnits(Knight.class, 1)
        .addUnits(Lancer.class, 1);

    Army enemyArmy = new Army()
        .addUnits(VampireImpl.class, 1)
        .addUnits(HealerImpl.class, 1);

    myArmy.unitBy(1).equipWeapon(superWeapon);

    enemyArmy.unitBy(0).equipWeapon(katana);
    enemyArmy.unitBy(1).equipWeapon(wand);

    assertTrue(Battle.fight(myArmy, enemyArmy));

  }

  @Test
  @Order(50)
  @DisplayName("Warlord")
  void warlord() {
    Warrior ronald = new Warlord();
    Warrior heimdall = new Knight();

    assertFalse(Battle.fight(heimdall, ronald));

    Army myArmy = new Army()
        .addUnits(Warlord.class, 1)
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 2)
        .addUnits(HealerImpl.class, 2);

    Army enemyArmy = new Army()
        .addUnits(Warlord.class, 3)
        .addUnits(VampireImpl.class, 1)
        .addUnits(HealerImpl.class, 2)
        .addUnits(Knight.class, 2);

    myArmy.moveUnits();
    enemyArmy.moveUnits();

    assertTrue(myArmy.unitBy(0) instanceof Lancer);
    assertTrue(myArmy.unitBy(1) instanceof HealerImpl);
    assertTrue(myArmy.unitBy(6) instanceof Warlord);

    assertTrue(enemyArmy.unitBy(0) instanceof VampireImpl);
    assertTrue(enemyArmy.unitBy(5) instanceof Warlord);
    assertTrue(enemyArmy.unitBy(4) instanceof Knight);

    assertEquals(6, enemyArmy.size());

    assertTrue(Battle.fight(myArmy, enemyArmy));
  }

}