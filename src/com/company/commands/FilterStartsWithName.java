package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Vector;

public class FilterStartsWithName extends AbstractCommands {
    public FilterStartsWithName(HumanBeingCollection collection) {
        super(collection);
    }
//Нужно сделать возвращение коллекции
    @Override
    public String execute(String name1) throws JAXBException, IOException {


            int k = 0;
            Vector<HumanBeing> c = new Vector<>();
            for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
                if (getCollection().getHumanBeings().get(i).getName().trim().startsWith(name1)) {
                    c.add(getCollection().getHumanBeings().get(i));
                    k++;
                }
            }
            if (k == 0) {
                System.out.println("Сори, ты ошибся, такого начала у имен нет");
            }
            return c.toString();
        }

    }
