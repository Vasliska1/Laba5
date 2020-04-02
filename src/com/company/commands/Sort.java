package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Collectors;

public class Sort extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {

     Vector<HumanBeing> newCollection =   h.getHumanBeings().stream().sorted(Comparator.comparing(HumanBeing::getName)).collect(Collectors.toCollection(Vector::new));
        h.getHumanBeings().clear();
        h.getHumanBeings().addAll(newCollection);
        return "Коллекция отсортирована.";

    }
}
