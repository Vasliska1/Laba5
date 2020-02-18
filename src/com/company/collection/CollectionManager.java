package com.company.collection;

import com.company.basis.*;
import com.company.exception.IncorrectValue;
import com.company.input.FileInput;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

public class CollectionManager {

    private HumanBeingCollection humanBeing;

    public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml";

    public CollectionManager(HumanBeingCollection humanBeing) {
        this.humanBeing = humanBeing;
    }

    public CommandHandler handler;

    public void help() {
        System.out.println(
                "help: Вывести справку по доступным командам " +
                        "\ninfo: Вывести информацию о коллекции " +
                        "\nshow: Вывести все элементы коллекции в строковом представлении " +
                        "\nadd: Добавить новый элемент в коллекцию " +
                        "\nupdate id: Обновить значение элемента коллекции, id которого равен заданному " +
                        "\nremove_by_id id: Удалить элемент из коллекции по его id " +
                        "\nclear: Очистить коллекцию " +
                        "\nsave: Сохранить коллекцию в файл " +
                        "\nexecute_script file_name: Считать и исполнить скрипт из указанного файла " +
                        "\nexit: Завершить программу (без сохранения в файл) " +
                        "\nremove_lower: Удалить из коллекции все элементы, меньшие, чем заданный " +
                        "\nreorder: Отсортировать коллекцию в порядке, обратном нынешнему " +
                        "\nsort: Отсортировать коллекцию в естественном порядке " +
                        "\nsum_of_impact_speed: Вывести сумму значений поля impactSpeed для всех элементов коллекции " +
                        "\nfilter_starts_with_name name: Вывести элементы, значение поля name которых начинается с заданной подстроки " +
                        "\nprint_field_descending_weapon_type weaponType: Вывести значения поля weaponType в порядке убывания ");
    }

    public void info() {
        System.out.println(humanBeing.toString());
    }

    public void show() {
        if (humanBeing.getHumanBeings().size() != 0) {
            humanBeing.getHumanBeings().forEach((value) -> System.out.println(value));
        } else System.out.println("Коллекция пуста.");

    }

    public HumanBeing readElement(IOInterface command) throws IncorrectValue {
        HumanBeing h = null;
        Boolean realHero = null;
        Boolean hasToothpick = null;
        WeaponType weapon = null;
        Mood mood = null;

        String name;
        do {
            command.output("Введите имя:");
            name = command.getNextInput().trim();
        } while (name.equals(""));

        String x1 = null;
        long x = 0;
        do {
            command.output("Введите координаты, x:");
            x1 = command.getNextInput().trim();
            if (x1.matches("[-+]?\\d+")) {
                x = Long.parseLong(x1);
                if (x < -671) {
                    x = 0;
                    System.out.println("Поле должно быть больше -671");
                }
            }
        } while (x == 0);

        float y = 0;
        String y1;
        do {
            command.output("y");
            y1 = command.getNextInput();
            if (y1.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                y = Float.parseFloat(y1);
                if (y > 649) {
                    y = 0;
                    System.out.println("Поле должно быть меньше 649");
                }
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

        String answer1 = null;
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
                speed = Long.parseLong(y1);
            }
        } while (y == -1);

        String answer2;
        do {
            command.output("Выберите и введите оружие: HAMMER, RIFLE, MACHINE GUN, BAT");
            answer2 = command.getNextInput().trim();
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
        } while (!answer2.equals("bat") && !answer2.equals("machine gun") && !answer2.equals("hammer") &&
                !answer2.equals("rifle") && !answer2.equals(""));

        String answer3;
        do {
            command.output("Выберите и введите настроение: SADNESS, APATHY, CALM, FRENZY");
            answer3 = command.getNextInput().trim();
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
        while (!answer3.equals("calm") && !answer3.equals("frenzy") && !answer3.equals("sadness")
                && !answer3.equals("apathy") && !answer3.equals(""));

        command.output("Введите название машины:");
        String nameOfCar = command.getNextInput().trim();

        h = new HumanBeing(name, new Coordinates(x, y), realHero,
                hasToothpick, speed, weapon, mood, new Car(nameOfCar));

        return h;
    }


    public void add(IOInterface c) throws IncorrectValue {
        humanBeing.getHumanBeings().add(this.readElement(c));
    }

    public void update(int id, IOInterface c) throws IncorrectValue {
        int k = 0;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).getId() == id) {
                k++;
            }
        }
        if (k > 0) {
            HumanBeing h = this.readElement(c);
            for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
                if (humanBeing.getHumanBeings().get(i).getId() == id) {
                    System.out.println(humanBeing.getHumanBeings().get(i).toString());
                    humanBeing.getHumanBeings().remove(i);
                    h.setId(id);
                    humanBeing.getHumanBeings().add(h);
                }
            }
            System.out.println("Элемент коллекции обновлен.");
        } else {
            System.out.println("Такого id нет");
        }


    }

    public void removeById(int id) {
        int k = 0;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).getId() == id) {
                k++;
            }
        }
        if (k > 0) {
            for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
                if (humanBeing.getHumanBeings().get(i).getId() == id) {
                    humanBeing.getHumanBeings().remove(i);
                }
            }
            System.out.println("Элемент коллекции удалён.");
        } else System.out.println("Такого id нет");

    }


    public void clear() {
        humanBeing.getHumanBeings().clear();
        System.out.println("Коллекция очищена.");
    }

    public void save() throws JAXBException, IOException {
        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(humanBeing, writer);
        marshaller.marshal(humanBeing, new File(file));
        System.out.println("Сохранено!");
    }


    public void executeScript(String fileName) throws IOException, IncorrectValue {
        CommandHandler handler = new CommandHandler(humanBeing);
        FileInput input = new FileInput(fileName);
        while (!input.getNextInput().equals("exit")) {
            handler.doCommand(input);
        }

    }


    public void removeLower(IOInterface c) throws IncorrectValue {
        HumanBeing human = this.readElement(c);
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).compareTo(human) == -1) {
                humanBeing.getHumanBeings().remove(i);
            }
        }
        System.out.println("Успешно удалено!");

    }


    public void reorder() {
        Collections.reverse(humanBeing.getHumanBeings());
        System.out.println("Отсортировано!");

    }

    public void sort() {

        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(this.humanBeing.getHumanBeings(), comparator);
        System.out.println("Коллекция отсортирована.");

    }

    public void sumOfImpactSpeed() {
        long k = 0;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            k += humanBeing.getHumanBeings().get(i).getImpactSpeed();
        }
        System.out.println("Сумма значений полей impactSpeed = " + k);
    }

    public void filterStartsWithName(String name1) {

        int k = 0;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).getName().startsWith(name1)) {
                System.out.println(humanBeing.getHumanBeings().get(i).toString());
                k++;
            }
            if (k == 0) {
                System.out.println("Сори, ты ошибся, такого начала у имен нет");
            }

        }
    }

    public void printFieldDescendingWeaponType() {
        Vector<WeaponType> collection = new Vector<>();
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            collection.add(humanBeing.getHumanBeings().get(i).getWeaponType());
        }
        Comparator<WeaponType> comparator = Comparator.comparing(obj -> obj.power);
        Collections.sort(collection, comparator);
        Collections.reverse(collection);

        for (WeaponType w : collection) {
            System.out.print(w.toString() + " ");
        }


      /* прощай наш пузырек, мы всегда будем тебя помнить
        for (int i = 0; i < humanBeing.getHumanBeings().size() - 1; i++) {
            for (int j = i + 1; j < humanBeing.getHumanBeings().size(); j++) {
                if (humanBeing.getHumanBeings().get(i).getWeaponType().power < humanBeing.getHumanBeings().get(j).getWeaponType().power) {
                    HumanBeing newHuman = humanBeing.getHumanBeings().get(j);
                    humanBeing.getHumanBeings().remove(j);
                    humanBeing.getHumanBeings().insertElementAt(humanBeing.getHumanBeings().get(i), j);
                    humanBeing.getHumanBeings().remove(i);
                    humanBeing.getHumanBeings().insertElementAt(newHuman, i);
                }
            }
        }
        for (int k = 0; k < humanBeing.getHumanBeings().size(); k++) {
            System.out.println(humanBeing.getHumanBeings().get(k).getWeaponType());
        }
*/
    }

}