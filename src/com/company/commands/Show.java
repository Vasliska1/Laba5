package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.List;
import java.util.stream.Collectors;

public class Show extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {
      // return h.getHumanBeings().stream().collect(Collectors.toList()).toString();
       // h.getHumanBeings().stream().toArray(Object[]::new);

       /* System.out.println(7);
        //List<HumanBeing> collection = h.getHumanBeings();
        StringBuilder result = new StringBuilder();
        if (h.getHumanBeings().size() != 0) {
            for (HumanBeing s : collection) {
                result.append(h.getHumanBeings()).append("\n    ");
            }
            return result.toString();
        } else return "Коллекция пуста.";*/

/*
        if (h.getHumanBeings().size() != 0) {

            return "d";
        } else return "Коллекция пуста.";*/

h.show();
return "d";

}}
