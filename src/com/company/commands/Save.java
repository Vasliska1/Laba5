package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        FileWriter writer = new FileWriter(file);
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(h, writer);
        marshaller.marshal(h, new File(file));
        writer.close();
        return "Сохранено!";

    }
}

