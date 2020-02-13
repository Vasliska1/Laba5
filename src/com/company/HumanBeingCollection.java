package com.company;
import java.io.*;
import java.util.Collections;


import java.util.Scanner;
import java.util.*;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "humanbeings")
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanBeingCollection{
    @XmlElement(name = "humanbeing")
    private Vector<HumanBeing> humanBeing;
    private Date date;

    public Vector<HumanBeing> getHumanBeings() {

        return humanBeing;
    }

    public void setHumanBeing(Vector<HumanBeing> humanBeing) {

        this.humanBeing = humanBeing;
    }

    public HumanBeingCollection(Vector<HumanBeing> humanBeing) {
        this.humanBeing = humanBeing;
    }

    public HumanBeingCollection() {

    }
    public Vector<HumanBeing> getCollection(){
        return this.humanBeing;
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
                        "\nexecute_script file_name:Считать и исполнить скрипт из указанного файла " +
                        "\nexit: Завершить программу (без сохранения в файл) " +
                        "\nremove_lower: Удалить из коллекции все элементы, меньшие, чем заданный " +
                        "\nreorder: Отсортировать коллекцию в порядке, обратном нынешнему " +
                        "\nsort: Отсортировать коллекцию в естественном порядке " +
                        "\nsum_of_impact_speed: Вывести сумму значений поля impactSpeed для всех элементов коллекции " +
                        "\nfilter_starts_with_name name: Вывести элементы, значение поля name которых начинается с заданной подстроки " +
                        "\nprint_field_descending_weapon_type weaponType: Вывести значения поля weaponType в порядке убывания ");
    }

    public void info() {
       System.out.println(this.toString());
    }

    public void show() {
        if (humanBeing.size() != 0){
        this.getCollection().forEach((value) -> System.out.println(value));}

//нэ ебу как это делать
         else System.out.println("Коллекция пуста.");
    }

    public void add() {
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
        System.out.println("Человек реальный герой? Введите да/нет");
        Scanner sc3 = new Scanner(System.in);
        String answer = sc3.nextLine().toLowerCase().trim();
        if (answer.equals("да")) {
            realHero = true;
        } else {
            realHero = false;
        }
        System.out.println("У человека есть зубочистка? Введите да/нет");
        Scanner sc4 = new Scanner(System.in);
        String answer1 = sc3.nextLine().toLowerCase().trim();
        if (answer1.equals("да")) {
            hasToothpick = true;
        } else {
            hasToothpick = false;
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
        String answer3 = sc3.nextLine().toLowerCase().trim();
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
        humanBeing.add(h3);

    }

    public void update() {


    }

    public void removeById(String ID) {



        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        //for (HumanBeing i:humanBeing){
        for (int i = 0; i <humanBeing.size() ; i++){
            if (humanBeing.get(i).getId()== number){

                humanBeing.remove(i);

            }
        }
            System.out.println("Элемент коллекции удалён.");

    }


    public void clear() {
        humanBeing.clear();
        System.out.print("Коллекция очищена.");
    }

    public void save() throws IOException {
        final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\f.xml";
        PrintWriter writer = new PrintWriter(file); writer.print(""); ;



        }
//тут будет полный взлом жопы


    public void executeScript(String fileName) {
      /*  try {
            String commandsStr = this.().getStrFromFile(fileName);
            String[] commands = commandsStr.trim().split("\n");
            for (String command : commands) {
                System.out.println();
                this.App();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/

    }

    public void exit() {

    }

    public void removeLower(HumanBeing h) {
        humanBeing.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        //Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        //Collections.sort(humanBeing, comparator);
        int i = humanBeing.indexOf(h);
        for (int j = 0; j <i ; j++) {
            humanBeing.remove(j);

        }


     /*   Iterator<HumanBeing> iterator = humanBeing.iterator();
        //Comparator comparator = humanBeing.comparator();
        Comparator<HumanBeing> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        int count = 0;
        while (iterator.hasNext()) {
            HumanBeing anotherHuman = iterator.next();
          if (comparator.compare(human, anotherHuman) > 0) {
                iterator.remove();
                count++;
            }
        }*/




}

    public void reorder() {
        int k=humanBeing.size();
        int n = (int)(humanBeing.size() /2) ;
        for (int i = 0; i <n ; i++) {
            HumanBeing newHuman = humanBeing.get(i);
            humanBeing.insertElementAt(humanBeing.get(k-i+1), i);
            humanBeing.insertElementAt(newHuman, k-i+1);
        }
    }

    public void sort() {

        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(humanBeing, comparator);

        //humanBeing.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public void sumOfImpactSpeed() {
    long k=0;
        for (int i = 0; i <humanBeing.size() ; i++) {
           k+= humanBeing.get(i).getImpactSpeed();
        }
        System.out.println("Сумма значений полей = " +k );
    }

    public void filterStartsWithName() {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        //for (HumanBeing i: humanBeing){
        for (int i = 0; i <humanBeing.size() ; i++) {
            if (humanBeing.get(i).getName().equals(name1)){
                humanBeing.remove(i);

            }
        }

    }

    public void printFieldDescendingWeaponType() {
    }
    @Override
    public String toString() {
        return "Тип коллекции: " + this.getCollection().getClass() +
                "\nДата инициализации: " + date+
                "\nКоличество элементов: " + this.getCollection().size();
    }
}

