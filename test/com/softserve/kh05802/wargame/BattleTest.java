package com.softserve.kh05802.wargame;

import com.softserve.kh05802.wargame.unit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
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
    @DisplayName("2. Fight")
    void fight2() {
        Warrior ramon = new Knight();
        Warrior slevin = new Warrior();

        boolean result = Battle.fight(ramon, slevin);

        assertTrue(result);
    }

    @Test
    @DisplayName("3. Fight")
    void fight3() {
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void fight4() {
        Warrior zeus = new Knight();
        Warrior godKiller = new Warrior();

        Battle.fight(zeus, godKiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void fight5() {
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();

        Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void fight6() {
        Warrior dragon = new Warrior();
        Warrior knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
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
    @DisplayName("8. Fight")
    void fight8() {

        Army army1 = new Army();
        army1.addUnits(Warrior.class, 3)
            .addUnits(Knight.class, 2)
            .addUnits(Warrior.class, 1)
            .addUnits(Knight.class, 1);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 2)
            .addUnits(Knight.class, 4);

//        System.out.println(army1);
//        System.out.println(army2);
        boolean result = Battle.fight(army1, army2);
        System.out.println(army1);
        System.out.println(army2);

        assertTrue(result);
    }

    @Test
    void fight() {
        // arrange
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();
        Warrior carl = new Knight();
        Warrior dave = new Warrior();

        // act
        boolean res1 = Battle.fight(chuck, bruce);
        boolean res2 = Battle.fight(dave, carl);

        // assert
        assertTrue(res1);
        assertFalse(res2);

        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    @DisplayName("1.2. Fight method testing (defender)")
    void fightWithDefenderTesting() {
        // arrange
        Warrior jimbo = new Defender();
        Warrior bruce = new Warrior();
        // act
        boolean res1 = Battle.fight(bruce, jimbo);
        // assert
        assertFalse(res1);
    }

    @Test
    @DisplayName("1.3. Fight method testing (defender with no damage)")
    void fightWithDefenderAndRookieTesting() {
        // arrange
        Warrior jimbo = new Defender();
        Warrior marcel = new Rookie();
        // act
        boolean res1 = Battle.fight(jimbo, marcel);
        // assert
        assertTrue(res1);
    }

    @Test
    @DisplayName("1.4. Fight method testing (defender with no damage & next fight)")
    void fightWithDefenderRookieAndWarriorTesting() {
        // arrange
        Warrior jimbo = new Defender();
        Warrior bruce = new Rookie();
        Warrior samael = new Warrior();
        // act
        boolean res1 = Battle.fight(jimbo, bruce);
        assertTrue(res1);
        boolean res2 = Battle.fight(jimbo, samael);
        // assert
        assertTrue(res2);
    }

    @Test
    @DisplayName("2.1. Battle method testing")
    void battle1() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 1);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 2);
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.2. Battle method testing")
    void battle2() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 3);
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.3. Battle method testing")
    void battle3() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 5);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 7);
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.4. Battle method testing")
    void battle4() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 20);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 21);
        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.5. Battle method testing")
    void battle5() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 10);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 11);
        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.6. Battle method testing")
    void battle6() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 11);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 7);
        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.7. Battle method testing")
    void battle7() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 50);
        Army army2 = new Army();
        army2.addUnits(Knight.class, 50);
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.8. Battle method testing")
    void battle8() {
        Army army1 = new Army();
        army1.addUnits(Knight.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 2);
        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.9. Battle method testing")
    void battle9() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior.class, 10);
        army1.addUnits(Defender.class, 5);
        army2.addUnits(Warrior.class, 5);
        army1.addUnits(Defender.class, 10);

        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.10. Battle method testing")
    void battle10() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Defender.class, 2);
        army1.addUnits(Warrior.class, 1);
        army1.addUnits(Defender.class, 1);
        army2.addUnits(Warrior.class, 5);

        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.11. Battle method testing")
    void battle11() {
        Warrior rookie = new Rookie();
        Warrior vampire = new Vampire();

        boolean res = Battle.fight(rookie, vampire);
        System.out.println(vampire);
        assertFalse(res);
    }

    @Test
    @DisplayName("2.12. Battle method testing")
    void battle12() {
        Warrior knight = new Knight();
        Warrior vampire = new Vampire();

        boolean res = Battle.fight(knight, vampire);
        System.out.println(knight);
        System.out.println(vampire);
        assertTrue(res);
    }

    @Test
    @DisplayName("2.13. Battle method testing")
    void battle13() {
        Warrior warrior = new Warrior();
        Warrior vampire = new Vampire();

        boolean res = Battle.fight(warrior, vampire);
        System.out.println(warrior);
        System.out.println(vampire);
        assertTrue(res);
    }


}