package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class SumOfImpactSpeed extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        int sum = h.getHumanBeings().stream().mapToInt(x -> Math.toIntExact(x.getImpactSpeed())).sum();

        return "Сумма значений полей impactSpeed = " + sum;
    }

}
