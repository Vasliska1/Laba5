package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Vector;

public class FilterStartsWithName extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h,String name1, IOInterface a) throws JAXBException, IOException {


            int k = 0;
            Vector<HumanBeing> c = new Vector<>();
            for (int i = 0; i < h.getHumanBeings().size(); i++) {
                if (h.getHumanBeings().get(i).getName().trim().startsWith(name1)) {
                    c.add(h.getHumanBeings().get(i));
                    k++;
                }
            }
            if (k == 0) {
                System.out.println("Сори, ты ошибся, такого начала у имен нет");
            }
            return c.toString();
        }

    }
