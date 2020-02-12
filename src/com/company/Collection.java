package com.company;
import java.util.Collections;


import java.util.Scanner;
import java.util.*;

public class Collection {
    private Vector<HumanBeing> humanBeing;
    private Date date;

    {
        Vector<HumanBeing> humanBeing = new Vector();
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

    public String info() {
        return "Тип коллекции: " + humanBeing.getClass() +
                "\nДата инициализации: " + date +
                "\nКоличество элементов: " + humanBeing.size();
    }

    public void show() {
        if (humanBeing.size() != 0) {
//нэ ебу как это делать
        } else System.out.println("Коллекция пуста.");
    }

    public void add(HumanBeing human) {
        humanBeing.add(human);
        System.out.println("Элемент добавлен");


    }

    public void update() {

    }

    public void removeById() {

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

    public void save() {
//тут будет полный взлом жопы, нужно ебаться с xml
    }

    public void executeScript() {

    }

    public void exit() {

    }

    public void removeLower(HumanBeing human) {
        /*Iterator<HumanBeing> iterator = humanBeing.iterator();
        //Comparator comparator = humanBeing.comparator();
        int count = 0;
        while (iterator.hasNext()) {
            HumanBeing anotherHuman = iterator.next();
          //  if (comparator.compare(human, anotherHuman) > 0) {
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

}

