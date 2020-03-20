package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Add extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h,IOInterface c) throws JAXBException, IOException {
        ReadElement r = new ReadElement();
        h.getHumanBeings().add(r.readElement(c));
        return "element dobavlen";
    }
}
