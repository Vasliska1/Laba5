package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Command {
    private String inputCommand = "";
    private String[] rightCommand;

   /* public Vector<HumanBeing> getCollectionFile() {
        Vector<HumanBeing> collection = new Vector();
        return collection;
    }*/
    public void App(HumanBeingCollection collection) throws IOException {
        System.out.println("Здравствуйте! Введите help для просмотра возможных команд");
        try (Scanner read = new Scanner(System.in)) {
            while (!inputCommand.equals("exit")) {
                inputCommand = read.nextLine();
                rightCommand = inputCommand.trim().split(" ", 2);
                try {
                    switch (rightCommand[0]) {
                        case "":
                            break;
                       case "exit":
                           System.out.println("До встречи!!!!");
                           break;
                        case "help":
                            collection.help();
                            break;
                        case "info":
                            collection.info();
                            break;
                        case "show":
                            collection.show();
                            break;
                        case "add":
// collection.add();
                            break;
                        case "update id":

                            break;
                        case "remove_by_id":
                           // collection.removeById(rightCommand[1]);
                            break;
                        case "clear":
                            collection.clear();
                            break;
                        case "save":
                            collection.save();
                            break;
                        case "execute_script":
                            //collection.executeScript(rightCommand[1]);
                            break;
                        case "remove_lower":
                            //collection.removeLower();
                            break;
                        case "reorder":
                            collection.reorder();
                            break;
                        case "sort":
                            collection.sort();
                            break;
                        case "sum_of_impact_speed":
                            collection.sumOfImpactSpeed();
                            break;
                        case "filter_starts_with_name":
                            collection.filterStartsWithName();
                            break;
                        case "print_field_descending_weapon_type":
                            collection.printFieldDescendingWeaponType();
                            break;
                        default:
                            System.out.println("Такой команды нет.");
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Введите аргумент.");
                }
            }
        }
    }

}

