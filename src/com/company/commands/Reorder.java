package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;

public class Reorder extends AbstractCommands {


    public Reorder(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() throws JAXBException, IOException {
            Collections.reverse(getCollection().getHumanBeings());
            return "Отсортировано!";
    }
}
