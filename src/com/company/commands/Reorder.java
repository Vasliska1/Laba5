package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;

public class Reorder extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
       h.reorder();
        return "Отсортировано!";
    }
}
