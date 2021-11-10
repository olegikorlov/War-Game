package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.equipment.*;
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
  @Order(24)
  @DisplayName("15. Battle")
  void battle15() {
    Army army1 = new Army().addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 2)
        .addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 6);
    Army army2 = new Army().addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 6)
        .addUnits(Lancer.class, 5);

    boolean res = Battle.fight(army1, army2);

    assertFalse(res);
  }

  @Test
  @Order(25)
  @DisplayName("16. Battle")
  void battle16() {
    Army army1 = new Army().addUnits(Lancer.class, 7)
        .addUnits(Vampire.class, 3)
        .addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 2);
    Army army2 = new Army().addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Vampire.class, 6)
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
        .addUnits(Vampire.class, 3)
        .addUnits(Healer.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(Healer.class, 1)
        .addUnits(Defender.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Healer.class, 1)
        .addUnits(Vampire.class, 6)
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
        .addUnits(Healer.class, 1)
        .addUnits(Warrior.class, 4)
        .addUnits(Healer.class, 1)
        .addUnits(Knight.class, 2);
    Army army2 = new Army()
        .addUnits(Warrior.class, 4)
        .addUnits(Defender.class, 4)
        .addUnits(Healer.class, 1)
        .addUnits(Vampire.class, 6)
        .addUnits(Lancer.class, 4);

    boolean res = Battle.fight(army1, army2);
    assertFalse(res);

  }

  @Test
  @Order(28)
  @DisplayName("Healer")
  void healer() {
    Warrior chuck = new Warrior();
    Warrior bruce = new Warrior();
    Warrior carl = new Knight();
    Warrior dave = new Warrior();
    Warrior mark = new Warrior();
    Warrior bob = new Defender();
    Warrior mike = new Knight();
    Warrior rog = new Warrior();
    Warrior lancelot = new Defender();
    Warrior eric = new Vampire();
    Warrior adam = new Vampire();
    Warrior richard = new Defender();
    Warrior ogre = new Warrior();
    Warrior freelancer = new Lancer();
    Warrior vampire = new Vampire();
    Healer priest = new Healer();

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
        .addUnits(Defender.class, 2)
        .addUnits(Healer.class, 1)
        .addUnits(Vampire.class, 2)
        .addUnits(Lancer.class, 2)
        .addUnits(Healer.class, 1)
        .addUnits(Warrior.class, 1);

    Army enemyArmy = new Army()
        .addUnits(Warrior.class, 2)
        .addUnits(Lancer.class, 4)
        .addUnits(Healer.class, 1)
        .addUnits(Defender.class, 2)
        .addUnits(Vampire.class, 3)
        .addUnits(Healer.class, 1);

    assertFalse(Battle.fight(myArmy, enemyArmy));

    Army army3 = new Army()
        .addUnits(Warrior.class, 1)
        .addUnits(Lancer.class, 1)
        .addUnits(Healer.class, 1)
        .addUnits(Defender.class, 2);

    Army army4 = new Army()
        .addUnits(Vampire.class, 3)
        .addUnits(Warrior.class, 1)
        .addUnits(Healer.class, 1)
        .addUnits(Lancer.class, 2);

    boolean result = Battle.fight(army3, army4);
    assertTrue(result);
  }

  @Test
  @Order(29)
  @DisplayName("Weapon")
  void weapon() {
    Warrior ogre = new Warrior();
    Warrior lancelot = new Knight();
    Defender richard = new Defender();
    Vampire eric = new Vampire();
    Warrior freelancer = new Lancer();
    Healer priest = new Healer();

    Equipment sword = new Sword();
    Equipment shield = new Shield();
    Equipment axe = new GreatAxe();
    Equipment katana = new Katana();
    Equipment wand = new MagicWand();
    Equipment superWeapon = new Weapon.Builder()
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

//    assertEquals(125, ogre.getHealth());
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
        .addUnits(Vampire.class, 1)
        .addUnits(Healer.class, 1);

    myArmy.unitBy(1).equipWeapon(superWeapon);

    enemyArmy.unitBy(0).equipWeapon(katana);
    enemyArmy.unitBy(1).equipWeapon(wand);

    assertTrue(Battle.fight(myArmy, enemyArmy));

  }

  @Test
  @Order(30)
  @DisplayName("Warlord")
  void warlord() {
    Warrior warlord = new Warlord();
    System.out.println(warlord);

    Army myArmy = new Army()
        .addUnits(Knight.class, 1)
        .addUnits(Warlord.class, 5)
        .addUnits(Knight.class, 2)
        .addUnits(Vampire.class, 3)
        .addUnits(Defender.class, 1)
        .addUnits(Warlord.class, 3)
        .addUnits(Lancer.class, 2);

    myArmy.moveUnits();

    System.out.println(myArmy);
    System.out.println(myArmy.unitBy(3));
  }
}