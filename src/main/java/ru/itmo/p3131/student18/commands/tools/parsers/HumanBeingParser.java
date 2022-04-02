package ru.itmo.p3131.student18.commands.tools.parsers;

import ru.itmo.p3131.student18.commands.tools.objectCheck.HumanBeingChecker;
import ru.itmo.p3131.student18.commands.tools.readers.ObjectFieldsReader;
import ru.itmo.p3131.student18.objectclasses.*;

public class HumanBeingParser {

    private String name;
    private Coordinates coordinates;
    private boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed; //Значение поля должно быть больше -163
    private WeaponType weaponType;
    private Mood mood;
    private Car car;

    private ObjectFieldsReader reader = new ObjectFieldsReader();
    private HumanBeingChecker checker = new HumanBeingChecker();


    public HumanBeing create() {
        while (!checker.isNameIsCorrect()) {
            name = checker.nameCheck(reader.nameScanner());
        }
        while (!checker.isCoordinatesIsCorrect()) {
            coordinates = checker.coordinatesCheck(reader.coordinatesScanner());
        }
        // Boolean values can not be null so they are validated in ObjectFieldsReader.
        realHero = reader.realHeroScanner();
        hasToothpick = reader.hasToothPickScanner();

        while (!checker.isImpactSpeedIsCorrect()) {
            impactSpeed = checker.impactSpeedCheck(reader.impactSpeedScanner());
        }
        // Can't go wrong with Enums as well. Exceptions will be caught at gson parsing or at reading validation.
        weaponType = reader.weaponScanner();
        mood = reader.moodScanner();

        // Car can be null.
        car = reader.carScanner();
        return new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, weaponType, mood, car);

    }

    public HumanBeing update(int newId) {
        while (!checker.isNameIsCorrect()) {
            name = checker.nameCheck(reader.nameScanner());
        }
        while (!checker.isCoordinatesIsCorrect()) {
            coordinates = checker.coordinatesCheck(reader.coordinatesScanner());
        }
        // Boolean values can not be null so they are validated in ObjectFieldsReader.
        realHero = reader.realHeroScanner();
        hasToothpick = reader.hasToothPickScanner();

        while (!checker.isImpactSpeedIsCorrect()) {
            impactSpeed = checker.impactSpeedCheck(reader.impactSpeedScanner());
        }
        // Can't go wrong with Enums as well. Exceptions will be caught at gson parsing or at reading validation.
        weaponType = reader.weaponScanner();
        mood = reader.moodScanner();

        // Car can be null.
        car = reader.carScanner();
        HumanBeing updatedHumanBeing = new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, weaponType, mood, car);
        updatedHumanBeing.setId(newId);
        return updatedHumanBeing;
    }

    public void initCheck(HumanBeing human) {
        //If name value is null, gson will throw an exception and end the program.

        checker.coordinatesCheck(human.getCoordinates());
        if (!checker.isCoordinatesIsCorrect()) {
            while (!checker.isCoordinatesIsCorrect()) {
                coordinates = checker.coordinatesCheck(reader.coordinatesScanner());
            }
            human.setCoordinates(coordinates);
        }
        checker.impactSpeedCheck(human.getImpactSpeed());
        if (!checker.isImpactSpeedIsCorrect()) {
            while (!checker.isImpactSpeedIsCorrect()) {
                impactSpeed = checker.impactSpeedCheck(reader.impactSpeedScanner());
            }
            human.setImpactSpeed(impactSpeed);
        }
    }
}
