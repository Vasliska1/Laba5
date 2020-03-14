package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends AbstractCommands {


    public Save(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() throws JAXBException, IOException {
            FileWriter writer = new FileWriter(file);
            JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
            Marshaller marshaller = context1.createMarshaller();
            marshaller.marshal(getCollection(), writer);
            marshaller.marshal(getCollection(), new File(file));
            writer.close();
            return "Сохранено!";

        }
    }

