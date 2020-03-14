package com.company.commands;

import com.company.basis.*;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ReadElement extends AbstractCommands {
    public ReadElement(HumanBeingCollection manager) {
        super(manager);
    }


    public HumanBeing readElement(IOInterface command) throws JAXBException, IOException {
        HumanBeing h = null;
        Boolean realHero;
        Boolean hasToothpick;
        WeaponType weapon = null;
        Mood mood = null;
        String name;
        try {
            do {
                command.output("Введите имя:");
                name = command.getNextInput().trim();
            } while (name.equals(""));

            String x1;
            long x = 0;
            do {
                try {


                    command.output("Введите координаты, x:");
                    x1 = command.getNextInput().trim();

                    if (x1.matches("[-+]?\\d+")) {
                        x = Long.parseLong(x1);

                        if (x < -671) {
                            x = 0;
                            System.out.println("Поле должно быть больше -671, нуб");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("нуб");
                }
            } while (x == 0);
            float y = 0;
            String y1;
            do {
                try {
                    command.output("y:");
                    y1 = command.getNextInput();
                    if (y1.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                        y = Float.parseFloat(y1);
                        if (y > 649) {
                            y = 0;
                            System.out.println("Максимальное значение y - 649, нуб");

                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("нуб");
                }
            } while (y == 0);

            String answer;
            do {
                command.output("Человек реальный герой? Введите yes/no");
                answer = command.getNextInput();
                if (answer.equals("yes")) {
                    realHero = true;
                } else if (answer.equals("no")) {
                    realHero = false;
                } else {
                    realHero = null;
                }
            } while (!answer.equals("yes") && !answer.equals("no"));

            String answer1;
            do {
                command.output("У человека есть зубочистка? Введите yes/no");
                answer1 = command.getNextInput().trim();
                if (answer1.equals("yes")) {
                    hasToothpick = true;
                } else if (answer1.equals("no")) {
                    hasToothpick = false;
                } else {
                    hasToothpick = null;
                }
            } while (!answer1.equals("yes") && !answer1.equals("no"));

            String speed1;
            long speed = -1;
            do {
                command.output("Введите скорость удара:");
                speed1 = command.getNextInput();
                if (speed1.matches("[-+]?\\d+")) {
                    speed = Long.parseLong(speed1);
                }
            } while (speed == -1);

            String answer2;
            do {
                command.output("Выберите и введите оружие: HAMMER, RIFLE, MACHINE GUN, BAT");
                answer2 = command.getNextInput().trim().toLowerCase();
                switch (answer2) {
                    case "hammer":
                        weapon = WeaponType.HAMMER;
                        break;
                    case "rifle":
                        weapon = WeaponType.RIFLE;
                        break;
                    case "machine gun":
                        weapon = WeaponType.MACHINE_GUN;
                        break;
                    case "bat":
                        weapon = WeaponType.BAT;
                        break;
                    case "":
                        weapon = null;
                        break;
                    default:
                        command.output("Такого варианта нет");
                        break;
                }
            } while (!answer2.toLowerCase().equals("bat") && !answer2.toLowerCase().equals("machine gun") &&
                    !answer2.toLowerCase().equals("hammer") &&
                    !answer2.toLowerCase().equals("rifle") && !answer2.equals(""));

            String answer3;
            do {
                command.output("Выберите и введите настроение: SADNESS, APATHY, CALM, FRENZY");
                answer3 = command.getNextInput().trim().toLowerCase();
                switch (answer3) {
                    case "sadness":
                        mood = Mood.SADNESS;
                        break;
                    case "apathy":
                        mood = Mood.APATHY;
                        break;
                    case "calm":
                        mood = Mood.CALM;
                        break;
                    case "frenzy":
                        mood = Mood.FRENZY;
                        break;
                    case "":
                        mood = null;
                        break;
                    default:
                        command.output("Такого варианта нет");
                        break;
                }
            }
            while (!answer3.toLowerCase().equals("calm") && !answer3.toLowerCase().equals("frenzy")
                    && !answer3.toLowerCase().equals("sadness")
                    && !answer3.toLowerCase().equals("apathy") && !answer3.equals(""));

            command.output("Введите название машины:");
            String nameOfCar = command.getNextInput().trim();

            h = new HumanBeing(name, new Coordinates(x, y), realHero,
                    hasToothpick, speed, weapon, mood, new Car(nameOfCar));
        } catch (NullPointerException e) {
            System.out.println("Ошибки в скрипте");
        }
        return h;
    }
    }
