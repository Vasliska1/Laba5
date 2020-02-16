package com.company;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

public class CollectionAdmin {

    private HumanBeingCollection humanBeing;
    private String inputCommand = "";
    private String[] rightCommand;
    public static final String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\file.xml";

    public CollectionAdmin(HumanBeingCollection humanBeing) {
        this.humanBeing = humanBeing;
    }

    public void doCommand(IOInterface inputCommand) throws IOException {
        rightCommand = inputCommand.getCurrentInput().trim().split(" ",2);
      //  rightCommand = inputCommand.toLowerCase().trim().split(" ", 2);
        try {
            switch (rightCommand[0]) {
                case "":
                    break;
                case "help":
                    this.help();
                    break;
                case "info":
                    this.info();
                    break;
                case "show":
                    this.show();
                    break;
                case "add":
                    this.add(inputCommand);
                    break;
                case "update":
                    this.update(Integer.parseInt(rightCommand[1]), inputCommand);
                    break;
                case "remove_by_id":
                   try {
                       this.removeById(Integer.parseInt(rightCommand[1])) ;
                   }
                   catch (Exception ex){};
                    break;
                case "clear":
                    this.clear();
                    break;
                case "exit":
                    break;
                case "save":
                    //this.save();
                    break;
                case "execute_script":
                    this.executeScript(rightCommand[1]);
                    break;
                case "remove_lower":
                    this.removeLower(inputCommand);
                    break;
                case "reorder":
                    this.reorder();
                    break;
                case "sort":
                    this.sort();
                    break;
                case "sum_of_impact_speed":
                    this.sumOfImpactSpeed();
                    break;
                case "filter_starts_with_name":
                    this.filterStartsWithName(rightCommand[1]);
                    break;
                case "print_field_descending_weapon_type":
                    this.printFieldDescendingWeaponType();
                    break;
                default:
                    System.out.println("Такой команды нет.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибочка, дружочек.") ;
        }

    }

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

    public HumanBeing readElement(IOInterface command) {
        //try {
            Boolean realHero;
            Boolean hasToothpick;
            WeaponType weapon = null;
            Mood mood = null;
            String name;

           //do {
               command.output("Введите имя:");
               name = command.getNextInput().trim();
           //}while(name.equals(""));


           //do {
               command.output("Введите координаты, x:");
                   Long x= command.getNextLongInput();
            //}while(x==0);

           //float y = 0;
          // do {
               command.output("y");
               Float y= command.getNextFloatInput();
               //Scanner sc2 = new Scanner(System.in);
               //if(sc2.hasNextFloat()){
               //y = sc2.nextFloat();}}
           //}
           // while(y==0);
               command.output("Человек реальный герой? Введите yes/no");
           String answer=command.getNextInput();
            if (answer.equals("yes")) {
                realHero = true;
            } else if (answer.equals("no")) {
                realHero = false;
            } else {
                realHero = null;
                command.output("Не понимаю");
            }
               command.output("У человека есть зубочистка? Введите yes/no");
            String answer1 = command.getNextInput().trim();
            if (answer1.equals("yes")) {
                hasToothpick = true;
            } else if (answer1.equals("no")) hasToothpick = false;
            else {
                hasToothpick = null;
                command.output("Не понимаю");
            }
               command.output("Введите скорость удара:");
           Long speed = command.getNextLongInput();
           command.output("Выберите и введите оружие: HAMMER, RIFLE, MACHINE GUN, BAT");
            String answer2 = command.getNextInput().trim();
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
                default:
                    command.output("Такого варианта нет");
                    break;
            }
            command.output("Выберите и введите настроение: SADNESS, APATHY, CALM, FRENZY");

            String answer3 = command.getNextInput().trim();
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
                default:
                    command.output("Такого варианта нет");
                    break;
            }
            command.output("Введите название машины:");

            String nameOfCar = command.getNextInput().trim();

            HumanBeing h = new HumanBeing(name, new Coordinates(x, y), realHero,
                    hasToothpick, speed, weapon, mood, new Car(nameOfCar));
            return h;
        //} catch (InputMismatchException e) {
          //  System.out.println("Чувак, попробуй еще раз");
        }

    public void add(IOInterface c) {
        humanBeing.getHumanBeings().add(this.readElement(c));
    }

    public void update(int id, IOInterface c) {
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


    }

    public void removeById(int id) throws Exception {

            int sizeStart= this.humanBeing.getHumanBeings().size();

            for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
                if (humanBeing.getHumanBeings().get(i).getId() == id) {
                    humanBeing.getHumanBeings().remove(i);
                }
            }
            int sizeFinish = this.humanBeing.getHumanBeings().size();
            if (sizeFinish<sizeFinish){
                System.out.println("Элемент коллекции удалён.");
            }
            else
                 throw  new Exception("Такой элементик не найден");



    }


    public void clear() {
        humanBeing.getHumanBeings().clear();
        System.out.println("Коллекция очищена.");
    }

    public void save() throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(humanBeing, writer);
        marshaller.marshal(humanBeing, new File(file));
    }


    public void executeScript(String fileName) throws IOException {
        FileInput input = new FileInput(fileName);
        while (!input.getNextInput().equals("exit")) {
            this.doCommand(input);
        }
    }


    public void removeLower(IOInterface c) {
        HumanBeing human = this.readElement(c);
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).compareTo(human) == -1) {
                humanBeing.getHumanBeings().remove(i);
            }
        }

    }


    public void reorder() {
        int i = 0;
        int j = humanBeing.getHumanBeings().size() - 1;
        System.out.println(j);
        while (j > i) {
            HumanBeing newHuman = humanBeing.getHumanBeings().get(j);
            humanBeing.getHumanBeings().remove(j);
            humanBeing.getHumanBeings().insertElementAt(humanBeing.getHumanBeings().get(i), j);
            humanBeing.getHumanBeings().remove(i);
            humanBeing.getHumanBeings().insertElementAt(newHuman, i);
            j--;
            i++;
        }

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
        try{
            int k = 0;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).getName().startsWith(name1)) {
                System.out.println(humanBeing.getHumanBeings().get(i).toString());
                k++;
            }
            if (k == 0){
                throw new Exception("Сори, ты ошибся, такого начала у имен нет");
            }

        }}
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    public void printFieldDescendingWeaponType() {

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

    }

}