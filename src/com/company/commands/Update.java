package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Update extends AbstractCommands {

    public Update(HumanBeingCollection collection) {
        super(collection);
    }

    // связать с ридэлементом( ридэлемент принимает коллекшн)
    @Override
    public String execute(int id, IOInterface c) throws JAXBException, IOException {
        int k = 0;
        for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
            if (getCollection().getHumanBeings().get(i).getId() == id) {
                k++;
            }
        }
        if (k > 0) {
            ReadElement element = new ReadElement(getCollection());
            HumanBeing h = element.readElement(c);
            for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
                if (getCollection().getHumanBeings().get(i).getId() == id) {

                    getCollection().getHumanBeings().remove(i);
                    h.setId(id);
                    getCollection().getHumanBeings().add(h);
                }
            }
            return "Элемент коллекции обновлен.";
        } else {
            return "Такого id нет";
        }

    }
}
