package ru.itmo.p3131.student18.commands.tools.readers;

import ru.itmo.p3131.student18.exeptions.NumberValueException;
import ru.itmo.p3131.student18.objectclasses.Car;
import ru.itmo.p3131.student18.objectclasses.Coordinates;
import ru.itmo.p3131.student18.objectclasses.Mood;
import ru.itmo.p3131.student18.objectclasses.WeaponType;

import java.util.Locale;
import java.util.Scanner;

public class ObjectFieldsReader {

    public String nameScanner() {
        boolean confirmation = false;
        String name = "";
        System.out.println("Insert a name(String):");
        while (!confirmation) {
            name = InputStream.getInstance().next().trim();
            if (name.equals("") || name.split(" ").length > 1) {
                System.out.println("Incorrect name. Name can't be empty or consist of more than one word.");
            } else {
                confirmation = true;
            }
        }
        return name;
    }

    public Coordinates coordinatesScanner() {
        boolean confirmationX = false;
        boolean confirmationY = false;
        long x = 0;
        long y = 0;
        System.out.println("Insert coordinates:");
        while (!confirmationX) {
            System.out.print("\tInsert x (Long): ");
            try {
                x = Long.parseLong(InputStream.getInstance().nextLine().trim());
                confirmationX = true;
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect value. Input value has to be Long");
            }
        }
        while (!confirmationY) {
            System.out.print("\tInsert y (Long): ");
            try {
                y = Long.parseLong(InputStream.getInstance().nextLine().trim());
                confirmationY = true;
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect value. Input value has to be Long");
            }
        }
        return new Coordinates(x, y);
    }

    public boolean realHeroScanner() {
        boolean confirmation = false;
        boolean realHero = false;
        System.out.println("Insert realHero value(true/false):");
        while (!confirmation) {
            String value = InputStream.getInstance().next().trim();
            if (value.equalsIgnoreCase("true")) {
                realHero = true;
                confirmation = true;
            } else if (value.equalsIgnoreCase("false")) {
                confirmation = true;
            } else {
                System.out.println("Incorrect value. Insert \"true\" or \"false\".");
            }
        }
        return realHero;
    }

    public boolean hasToothPickScanner() {
        boolean confirmation = false;
        boolean hasToothPick = false;
        System.out.println("Insert hasToothPick value(true/false):");
        while (!confirmation) {
            String value = InputStream.getInstance().next().trim();
            if (value.equalsIgnoreCase("true")) {
                hasToothPick = true;
                confirmation = true;
            } else if (value.equalsIgnoreCase("false")) {
                confirmation = true;
            } else {
                System.out.println("Reading error. Insert \"true\" or \"false\".");
            }
        }
        return hasToothPick;
    }

    public float impactSpeedScanner() {
        boolean confirmation = false;
        float impactSpeed = 0.0f;
        System.out.println("Insert impact speed (float): ");
        while (!confirmation) {
            try {
                impactSpeed = Float.parseFloat(InputStream.getInstance().nextLine().trim());
                if (impactSpeed <= -163) {
                    throw new NumberValueException("Incorrect value. Impact speed value has to be more than -163.0");
                }
                confirmation = true;
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect value. Input value has to be float");
            } catch (NumberValueException e) {
                System.out.println(e.getMessage());
            }
        }
        return impactSpeed;
    }

    public WeaponType weaponScanner() {
        boolean confirmation = false;
        String weaponContainer = null;
        while (!confirmation) {
            System.out.println("Insert weapon type:" +
                    "\n\tHammer\n\tAxe\n\tShotgun\n\tRifle\n\tMachine_gun");
            try {
                weaponContainer = InputStream.getInstance().nextLine().toUpperCase(Locale.ROOT).trim();
                WeaponType.valueOf(weaponContainer);
                confirmation = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Inserted value doesn't match any of suggested values." +
                        "\nMake sure that you use \"_\" instead of \"space\" bar.");
            }
        }
        return WeaponType.valueOf(weaponContainer);
    }

    public Mood moodScanner() {
        boolean confirmation = false;
        String moodContainer = null;
        while (!confirmation) {
            System.out.println("Insert mood:" +
                    "\n\tSadness\n\tLonging\n\tGloom\n\tRage" +
                    "\n This field can be empty, if you press \"Enter\" button.");
            moodContainer = InputStream.getInstance().nextLine().toUpperCase(Locale.ROOT).trim();
            if (moodContainer.equals("")) {
                return null;
            }
            try {
                Mood.valueOf(moodContainer);
                confirmation = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Inserted value doesn't match any of suggested values.");
            }
        }
        return Mood.valueOf(moodContainer);
    }

    public Car carScanner() {
        boolean confirmation = false;
        boolean isCarCool = false;
        System.out.println("Does this Human Being have a car? (Yes(y) / no (n)):");
        while (!confirmation) {
            String value = InputStream.getInstance().next().trim();
            if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("y")) {
                System.out.println("Insert car's value of \"cool\" (true / false):");
                while (!confirmation) {
                    value = InputStream.getInstance().next().trim();
                    if (value.equalsIgnoreCase("true")) {
                        isCarCool = true;
                        confirmation = true;
                    } else if (value.equalsIgnoreCase("false")) {
                        confirmation = true;
                    } else {
                        System.out.println("Reading error. Insert \"true\" or \"false\".");
                    }
                }
                return new Car(isCarCool);
            } else if (value.equalsIgnoreCase("No") || value.equalsIgnoreCase("n")) {
                return null;
            } else {
                System.out.println("Reading error. Insert \"Yes\" or \"No\".");
            }
        }
        return null;
    }
}
