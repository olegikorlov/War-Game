package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
    Warrior unit1 = new Defender();
    Warrior unit2 = new Rookie();

    Battle.fight(unit1, unit2);

    assertEquals(60, unit1.getHealth());
  }

  @Test
  @Order(9)
  @DisplayName("9. Fight")
  void fight9() {
    Warrior unit1 = new Defender();
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
        .addUnits(Defender.class, 4)
        .addUnits(Defender.class, 5);
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
    army1.addUnits(Defender.class, 5)
        .addUnits(Warrior.class, 20);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 21)
        .addUnits(Defender.class, 4);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(18)
  @DisplayName("9. Battle")
  void battle9() {
    Army army1 = new Army();
    army1.addUnits(Warrior.class, 10)
        .addUnits(Defender.class, 5);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 5);
    army1.addUnits(Defender.class, 10);

    boolean res = Battle.fight(army1, army2);
    assertTrue(res);
  }

  @Test
  @Order(19)
  @DisplayName("10. Battle")
  void battle10() {
    Army army1 = new Army();
    army1.addUnits(Defender.class, 2)
        .addUnits(Warrior.class, 1)
        .addUnits(Defender.class, 1);
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
    army1.addUnits(Defender.class, 5)
        .addUnits(Vampire.class, 6)
        .addUnits(Warrior.class, 7);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 6)
        .addUnits(Defender.class, 6)
        .addUnits(Vampire.class, 6);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(21)
  @DisplayName("12. Battle")
  void battle12() {
    Army army1 = new Army();
    army1.addUnits(Defender.class, 2)
        .addUnits(Vampire.class, 3)
        .addUnits(Warrior.class, 4);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 3);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(22)
  @DisplayName("13. Battle")
  void battle13() {
    Army army1 = new Army();
    army1.addUnits(Defender.class, 11)
        .addUnits(Vampire.class, 3)
        .addUnits(Warrior.class, 4);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 13);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @Order(23)
  @DisplayName("14. Battle")
  void battle14() {
    Army army1 = new Army();
    army1.addUnits(Defender.class, 9)
        .addUnits(Vampire.class, 3)
        .addUnits(Warrior.class, 8);
    Army army2 = new Army();
    army2.addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 13);

    boolean res = Battle.fight(army1, army2);

    assertTrue(res);
  }

  @Test
  @DisplayName("1.5. Fight method testing (vampire)")
  void fightWithVampireTesting() {
    // arrange
    Warrior jimbo = new Defender();
    Warrior vladimir = new Vampire();
    // act
    boolean res1 = Battle.fight(jimbo, vladimir);
    // assert
    assertTrue(res1);
  }

}