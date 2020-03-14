package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import java.util.Collections;
import java.util.Comparator;

public class Sort extends AbstractCommands {

    public Sort(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() {

        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(this.getCollection().getHumanBeings(), comparator);
        return "Коллекция отсортирована.";

    }
}
