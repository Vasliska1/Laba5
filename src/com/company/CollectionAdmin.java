package com.company;
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

    public void doCommand(String inputCommand) throws IOException {
        rightCommand = inputCommand.toLowerCase().trim().split(" ", 2);
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
                    this.add();
                    break;
                case "update":
                    this.update(Integer.parseInt(rightCommand[1]));
                    break;
                case "remove_by_id":
                    this.removeById(Integer.parseInt(rightCommand[1]));
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
                    this.removeLower();
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
            System.out.println("Ошибочка, дружочек.");
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

    public void add() {
        try {
            Boolean realHero;
            Boolean hasToothpick;
            WeaponType weapon = null;
            Mood mood = null;
            System.out.println("Введите имя:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine().trim();
            System.out.println("Введите координаты, x:");
            Scanner sc1 = new Scanner(System.in);
            Long x = sc1.nextLong();
            System.out.println("y:");
            Scanner sc2 = new Scanner(System.in);
            Float y = sc2.nextFloat();
            System.out.println("Человек реальный герой? Введите yes/no");
            Scanner sc3 = new Scanner(System.in);
            String answer = sc3.nextLine().toLowerCase().trim();
            if (answer.equals("yes")) {
                realHero = true;
            } else if (answer.equals("no")) {
                realHero = false;
            } else {
                realHero = null;
                System.out.println("Не понимаю");
            }
            System.out.println("У человека есть зубочистка? Введите yes/no");
            Scanner sc4 = new Scanner(System.in);
            String answer1 = sc4.nextLine().toLowerCase().trim();
            if (answer1.equals("yes")) {
                hasToothpick = true;
            } else if (answer1.equals("no")) hasToothpick = false;
            else {
                hasToothpick = null;
                System.out.println("Не понимаю");
            }
            System.out.println("Введите скорость удара:");
            Scanner sc5 = new Scanner(System.in);
            Long speed = sc5.nextLong();
            System.out.println("Выберите и введите оружие: HAMMER, RIFLE, MACHINE GUN, BAT");
            Scanner sc6 = new Scanner(System.in);
            String answer2 = sc6.nextLine().toLowerCase().trim();
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
                case "Bat":
                    weapon = WeaponType.BAT;
                    break;
                default:
                    System.out.println("Такого варианта нет");
                    break;
            }
            System.out.println("Выберите и введите настроение: SADNESS, APATHY, CALM, FRENZY");
            Scanner sc7 = new Scanner(System.in);
            String answer3 = sc7.nextLine().toLowerCase().trim();
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
                    System.out.println("Такого варианта нет");
                    break;
            }
            System.out.println("Введите название машины:");
            Scanner sc8 = new Scanner(System.in);
            String nameOfCar = sc8.nextLine().trim();

            HumanBeing h3 = new HumanBeing(name, new Coordinates(x, y), realHero,
                    hasToothpick, speed, weapon, mood, new Car(nameOfCar));
            humanBeing.getHumanBeings().add(h3);
        } catch (InputMismatchException e) {
            System.out.println("Чувак, попробуй еще раз");
        }
    }

    public void update(Integer id) {
        HumanBeing h = null;
        for (int i = 0; i < humanBeing.getHumanBeings().size(); i++) {
            if (humanBeing.getHumanBeings().get(i).getId() == id) {
                h = humanBeing.getHumanBeings().get(i);
                humanBeing.getHumanBeings().remove(i);
                //доюавить новый
            }
            humanBeing.getHumanBeings().insertElementAt(h, i);
        }
        System.out.println("Элемент коллекции обновлен.");


    }

    public void removeById(int id) {
        try {
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
catch (Exception ex) {
    System.out.println(ex.getMessage());
        }

    }


    public void clear() {
        humanBeing.getHumanBeings().clear();
        System.out.println("Коллекция очищена.");
    }

    /*public void save() throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(humanBeing, writer);
        marshaller.marshal(humanBeing, new File(file));
    }*/

    public void executeScript(String fileName) throws IOException {
        String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\" + fileName;
        Scanner in = new Scanner(new File(file));
        ArrayList<String> script = new ArrayList<>();
        while (in.hasNext())
            script.add(in.nextLine().toLowerCase());
        System.out.println(script);
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i <script.size() ; i++) {
            if(script.get(i).startsWith("add")){
                index.add(i);
            }
        }
        for (String c : script) {
            this.doCommand(c);
        }
        

    }


    public void removeLower() {
        //add

        /*for (int i = 0; i < humanBeing.size(); i++) {
            if (humanBeing.get(i).compareTo(human) == -1) {
                humanBeing.remove(i);
            }
        }*/

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