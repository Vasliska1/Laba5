package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

public class Add extends AbstractCommands {

    private HumanBeing humanBeing;

    public Add(HumanBeing humanBeing){
    this.humanBeing=humanBeing;
}
    @Override
    public String execute(HumanBeingCollection h,IOInterface c) throws JAXBException, IOException {
        //ReadElement r = new ReadElement();
        h.getHumanBeings().add(humanBeing);
        return "element dobavlen";
    }
}
