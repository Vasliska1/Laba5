package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SumOfImpactSpeed extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        long k = 0;
        for (int i = 0; i < h.getHumanBeings().size(); i++) {
            k += h.getHumanBeings().get(i).getImpactSpeed();
        }
        return "Сумма значений полей impactSpeed = " + k;
    }

}
