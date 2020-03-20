package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.Collections;
import java.util.Comparator;

public class Sort extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {

        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(h.getHumanBeings(), comparator);
        return "Коллекция отсортирована.";

    }
}
