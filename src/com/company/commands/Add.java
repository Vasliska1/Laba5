package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Add extends AbstractCommands {

    public Add(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute(IOInterface c) throws JAXBException, IOException {
        ReadElement r = new ReadElement(getCollection());
        getCollection().getHumanBeings().add(r.readElement(c));
        return "element dobavlen";
    }
}
