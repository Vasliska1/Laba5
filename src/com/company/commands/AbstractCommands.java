package com.company.commands;

import com.company.basis.HumanBeing;

import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Vector;

public abstract class AbstractCommands {
    //принимать file??
    public String file;
    private HumanBeingCollection collection;

    public AbstractCommands(HumanBeingCollection collection) {
        this.collection = collection;
    }

    public String execute() throws JAXBException, IOException {
        return null;
    }

    public String execute(String s) throws JAXBException, IOException {
        return null;
    }

    public String execute(int s, IOInterface i) throws JAXBException, IOException {
        return null;
    }
    public String execute(IOInterface i) throws JAXBException, IOException {
        return null;
    }


    //public Vector<HumanBeing> execute(String s);
    public HumanBeingCollection getCollection() {
        return collection;
    }

}
