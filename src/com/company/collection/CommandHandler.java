package com.company.collection;

import com.company.exception.IncorrectValue;
import com.company.exception.NoArgument;
import com.company.input.IOInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Вызывает методы у CommandManager
 *
 * @see CollectionManager
 */
public class CommandHandler {
    private final HumanBeingCollection humanBeing;
    CollectionManager manager;
    CommandReader reader = new CommandReader();
    private String[] rightCommand;

    public CommandHandler(HumanBeingCollection humanBeing, String file) {
        this.humanBeing = humanBeing;
        this.manager = new CollectionManager();
    }

    /**
     * С помошью класса CommandReader принимимает команды и вызвает их у CommandManager
     *
     * @param inputCommand
     * @throws IOException
     * @throws IncorrectValue
     * @throws NoArgument
     */
   /* public void doCommand(IOInterface inputCommand) throws IOException, IncorrectValue, NoArgument {
        rightCommand = reader.returnCommand(inputCommand);

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
                try {
                    if (rightCommand.length < 2) throw new NoArgument("Вы должны ввести айди");
                    manager.update(Integer.parseInt(rightCommand[1]), inputCommand);
                } catch (NoArgument e) {
                    e.getMessage();
                } catch (NumberFormatException e) {
                    System.out.println("Мэн, введи число");
                }

                break;
            case "remove_by_id":
                try {
                    if (rightCommand.length < 2) throw new NoArgument("Вы должны ввести айди");
                    manager.removeById(Integer.parseInt(rightCommand[1]));
                } catch (NoArgument e) {
                    e.getMessage();
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
                System.exit(0);
                break;
            case "save":
                try {
                    manager.save();
                } catch (Exception e) {
                    System.out.println("Не могу сохранить:" + e.getMessage());
                }
                break;
            case "execute_script":
                try {
                    if (rightCommand.length < 2) throw new NoArgument("Вы должны ввести имя скрипта");
                    manager.executeScript(rightCommand[1]);
                } catch (NoArgument e) {
                    e.getMessage();
                } catch (FileNotFoundException e) {
                    System.out.println("Такой файлик не найден");
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
                try {
                    if (rightCommand.length < 2) throw new NoArgument("Вы должны ввести начало имени");
                    manager.filterStartsWithName(rightCommand[1]);
                } catch (NoArgument e) {
                    e.getMessage();
                }
                break;
            case "print_field_descending_weapon_type":
                manager.printFieldDescendingWeaponType();
                break;
            default:
                System.out.println("Такой команды нет.");
        }


    }
*/
}
