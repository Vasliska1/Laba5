package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class FilterStartsWithName extends AbstractCommands {
    private String name1;

    public FilterStartsWithName(String name1) {
        this.name1 = name1;
    }

    @Override
    public String execute(HumanBeingCollection h, IOInterface a) throws JAXBException, IOException {
       List<HumanBeing> newHumamCollection = h.getHumanBeings().stream().filter(s -> s.getName().trim().contains(name1)).sorted(Comparator.comparing(x-> x.getCoordinates().getX())).
                collect(Collectors.toList());
       if (newHumamCollection.size()>0)
        return newHumamCollection.toString();
       else
           return "Такого имени нет";
    }

}
