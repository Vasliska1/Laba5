package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Update extends AbstractCommands {
    private String id;

    public Update(String id){
    this.id =id;
}
    @Override
    public String execute(HumanBeingCollection humanBeingCollection,IOInterface c) throws JAXBException, IOException {
        int k = 0;
        for (int i = 0; i < humanBeingCollection.getHumanBeings().size(); i++) {
            if (humanBeingCollection.getHumanBeings().get(i).getId().toString().equals(id)) {
                k++;
            }
        }
        if (k > 0) {
            ReadElement element = new ReadElement();
            HumanBeing h = element.readElement(c);
            for (int i = 0; i < humanBeingCollection.getHumanBeings().size(); i++) {
                if (humanBeingCollection.getHumanBeings().get(i).getId().toString().equals(id)) {

                    humanBeingCollection.getHumanBeings().remove(i);
                    h.setId(Integer.parseInt(id));
                    humanBeingCollection.getHumanBeings().add(h);
                }
            }
            return "Элемент коллекции обновлен.";
        } else {
            return "Такого id нет";
        }

    }
}
