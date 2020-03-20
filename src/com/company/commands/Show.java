package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.List;

public class Show extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {
        System.out.println(7);
        List<HumanBeing> collection = h.getHumanBeings();
        StringBuilder result = new StringBuilder();
        if (collection.size() != 0) {
            for (HumanBeing s : collection) {
                result.append(h.getHumanBeings()).append("\n    ");
            }
            return result.toString();
        } else return "Коллекция пуста.";
    }

    /*     if (humanBeing.getHumanBeings().size() != 0) {
            humanBeing.getHumanBeings().forEach((value) -> System.out.println(value));
        } else System.out.println("Коллекция пуста.");*/

}
