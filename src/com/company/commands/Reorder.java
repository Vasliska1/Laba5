package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reorder extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        List result = h.getHumanBeings().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        //Collections.reverse(h.getHumanBeings());
        System.out.println(result);
        return "Отсортировано!";
    }
}
