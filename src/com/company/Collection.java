package com.company;



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
        for (HumanBeing i:humanBeing){
            if ((int) humanBeing.get(i).getId()== number){

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
        Iterator<HumanBeing> iterator = humanBeing.iterator();
        Comparator comparator = humanBeing.comparator();
        int count = 0;
        while (iterator.hasNext()) {
            HumanBeing anotherHuman = iterator.next();
            if (comparator.compare(human, anotherHuman) > 0) {
                iterator.remove();
                count++;
            }
        }

    }


}

    public void reorder() {

    }

    public void sort() {
// Collections.sort(humanBeing);
    }

    public void sumOfImpactSpeed() {

    }

    public void filterStartsWithName() {

    }

    public void printFieldDescendingWeaponType() {
    }

}

