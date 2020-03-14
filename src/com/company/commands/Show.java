package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import java.util.List;

public class Show extends AbstractCommands {


    public Show(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() {
        List<HumanBeing> collection = getCollection().getHumanBeings();
        StringBuilder result = new StringBuilder();
        if (collection.size() != 0) {
            for (HumanBeing s: collection) {
                result.append(getCollection().getHumanBeings()).append("\n    ");
            }
            return result.toString();
        }
        else return "Коллекция пуста.";
    }

    /*     if (humanBeing.getHumanBeings().size() != 0) {
            humanBeing.getHumanBeings().forEach((value) -> System.out.println(value));
        } else System.out.println("Коллекция пуста.");*/

}
