package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Exit extends AbstractCommands {
    public Exit(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() throws JAXBException, IOException {
        System.exit(0);
        return "chao";
    }
}
