package com.company.collection;

import com.company.basis.*;
import com.company.exception.InncorrectValue;
import com.company.input.IOInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class CommandHandler {
    private final HumanBeingCollection humanBeing;
    CollectionManager manager;
    CommandReader reader = new CommandReader();
    private String[] rightCommand;

    public CommandHandler(HumanBeingCollection humanBeing) {
        this.humanBeing = humanBeing;
        this.manager = new CollectionManager(humanBeing);
    }

    public void doCommand(IOInterface inputCommand) throws IOException {
        rightCommand = reader.returnCommand(inputCommand);
        try {
            switch (rightCommand[0]) {
                case "":
                    break;
                case "help":
                    manager.help();
                    break;
                case "info":
                    manager.info();
                    break;
                case "show":
                    manager.show();
                    break;
                case "add":
                    manager.add(inputCommand);
                    break;
                case "update":
                    manager.update(Integer.parseInt(rightCommand[1]), inputCommand);
                    break;
                case "remove_by_id":
                    try {
                        manager.removeById(Integer.parseInt(rightCommand[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Мэн, введи число");
                    } catch (Exception e) {
                        System.out.println("Такой элементик не найден");
                    }
                    break;
                case "clear":
                    manager.clear();
                    break;
                case "exit":
                    break;
                case "save":
                    try {
                        manager.save();
                    } catch (Exception e) {
                        System.out.println("Не могу сохранить:");
                        e.printStackTrace();
                    }
                    break;
                case "execute_script":
                    try {
                        manager.executeScript(rightCommand[1]);
                    } catch (FileNotFoundException e) {
                        System.out.println("Файл не найден))");
                    }
                    break;
                case "remove_lower":
                    manager.removeLower(inputCommand);
                    break;
                case "reorder":
                    manager.reorder();
                    break;
                case "sort":
                    manager.sort();
                    break;
                case "sum_of_impact_speed":
                    manager.sumOfImpactSpeed();
                    break;
                case "filter_starts_with_name":
                    manager.filterStartsWithName(rightCommand[1]);
                    break;
                case "print_field_descending_weapon_type":
                    manager.printFieldDescendingWeaponType();
                    break;
                default:
                    System.out.println("Такой команды нет.");
            }
        } catch (Exception ex) {
            System.out.println("Ошибочка, дружочек.");
            ex.printStackTrace();

        }

    }

}
