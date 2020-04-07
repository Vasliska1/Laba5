package com.company.commands;

import com.company.basis.HumanBeing;

import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

public class AbstractCommands implements Serializable {
    //принимать file??
    public String file= "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml";
    private HumanBeingCollection collection;


    public String execute(HumanBeingCollection h,IOInterface c) throws JAXBException, IOException, ClassNotFoundException {
        return null;
    }




}
