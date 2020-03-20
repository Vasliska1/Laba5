package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

public class Help extends AbstractCommands {


    @Override
    public String execute(HumanBeingCollection h,IOInterface c) {
        return "help: Вывести справку по доступным командам " +
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
                "\nprint_field_descending_weapon_type weaponType: Вывести значения поля weaponType в порядке убывания ";

    }
}
