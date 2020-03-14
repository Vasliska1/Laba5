package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class RemoveLower extends AbstractCommands {


    public RemoveLower(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute(IOInterface c) throws JAXBException, IOException {
        ReadElement r = new ReadElement(getCollection());
        HumanBeing human = r.readElement(c);
        for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
            if (getCollection().getHumanBeings().get(i).compareTo(human) == -1) {
                getCollection().getHumanBeings().remove(i);
            }
        }
        return "Успешно удалено!";

    }
}
