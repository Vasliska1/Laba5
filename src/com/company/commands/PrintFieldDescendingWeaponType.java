package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.basis.WeaponType;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.stream.Collectors;

public class PrintFieldDescendingWeaponType extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h,IOInterface c) throws JAXBException, IOException {

        Vector<WeaponType> result =
                h.getHumanBeings().stream()
                        .map(HumanBeing::getWeaponType)
                        .sorted(Comparator.nullsLast(Comparator.comparing(obj -> obj.power, Comparator.reverseOrder())))
                        .collect(Collectors.toCollection(Vector::new));
        return result.toString();
    }



}
