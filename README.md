# Wargame

You can to initiate the duel between 2 warriors and define the strongest of them.

```Java
    Warrior unit1 = new Defender();
    Warrior unit2 = new Rookie();

    Battle.fight(unit1,unit2);
```

Also, you can to initiate the duel between two armies.

```Java
    Army army1 = new Army();
    army1.addUnits(Defender.class,9)
        .addUnits(Vampire.class,3)
        .addUnits(Warrior.class,8);
    Army army2 = new Army();
    army2.addUnits(Warrior.class,4)
        .addUnits(Defender.class,4)
        .addUnits(Vampire.class,13);

    Battle.fight(army1,army2);
```

The [Army](https://py.checkio.org/ru/mission/army-battles/) may consist this such of the units.

* [Warriors](https://py.checkio.org/en/mission/the-warriors/)
* [Knight](https://py.checkio.org/ru/mission/the-warriors/)
* Rookie
* [Defender](https://py.checkio.org/ru/mission/the-defenders/)
* [Vampire](https://py.checkio.org/ru/mission/the-vampires/)

[Tests](https://github.com/CheckiO-Missions/checkio-mission-set-war-the-vampires/blob/master/verification/tests.py)

![Wargame](https://d17mnqrx9pmt3e.cloudfront.net/media/missions/media/4e0dd625813446a595c6f45e5033d355/warrior.png)