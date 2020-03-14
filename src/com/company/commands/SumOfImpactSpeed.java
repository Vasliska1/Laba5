package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SumOfImpactSpeed extends AbstractCommands {


    public SumOfImpactSpeed(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() throws JAXBException, IOException {
            long k = 0;
            for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
                k += getCollection().getHumanBeings().get(i).getImpactSpeed();
            }
            return "Сумма значений полей impactSpeed = " + k;
        }

}
