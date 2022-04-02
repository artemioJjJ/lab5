package ru.itmo.p3131.student18.commands.tools.objectCheck;

import ru.itmo.p3131.student18.exeptions.NumberValueException;
import ru.itmo.p3131.student18.objectclasses.Coordinates;

public class HumanBeingChecker {

    private boolean nameIsCorrect = false;
    private boolean coordinatesIsCorrect = false;
    private boolean impactSpeedIsCorrect = false;


    public String nameCheck(String name) {
        if (name.equals("") || name.split(" ").length > 1) {
            System.out.println("Incorrect name. Name can't be empty or consist of more than one word.");
        } else {
            nameIsCorrect = true;
        }
        return name;
    }

    public Coordinates coordinatesCheck(Coordinates coordinates) {
        if (coordinates == null) {
            System.out.println("Coordinates value can not be \"null\".");
        } else {
            coordinatesIsCorrect = true;
        }
        return coordinates;
    }

    public float impactSpeedCheck(float impactSpeed) {
        try {
            if (impactSpeed <= -163) {
                throw new NumberValueException("\n Incorrect value. Impact speed value has to be more than -163.0");
            } else {
                impactSpeedIsCorrect = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nIncorrect value. Input value has to be float");
        } catch (NumberValueException e) {
            System.out.println(e.getMessage());
        }
        return impactSpeed;
    }

    public boolean isNameIsCorrect() {
        return nameIsCorrect;
    }

    public boolean isCoordinatesIsCorrect() {
        return coordinatesIsCorrect;
    }

    public boolean isImpactSpeedIsCorrect() {
        return impactSpeedIsCorrect;
    }
}
