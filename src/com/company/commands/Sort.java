package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Sort extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {
       h.getHumanBeings().stream().sorted().collect(Collectors.toList());
        for (HumanBeing humanBeing : h.getHumanBeings()) {
            System.out.println(humanBeing);

        }
        Comparator<HumanBeing> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort( h.getHumanBeings(), comparator);

        return "Коллекция отсортирована.";

    }
}
