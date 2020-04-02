package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;

public class FilterStartsWithName extends AbstractCommands {
    private String name1;

    public FilterStartsWithName(String name1) {
        this.name1 = name1;
    }

    @Override
    public String execute(HumanBeingCollection h, IOInterface a) throws JAXBException, IOException {

        return h.getHumanBeings().stream().filter(s ->s.getName().trim().startsWith(name1)).
                collect(Collectors.toList()).toString();
    }

}
