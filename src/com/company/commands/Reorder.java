package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Reorder extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        /*System.out.println(h.getHumanBeings());
        Vector<HumanBeing> vector = h.getHumanBeings().stream().
                sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(Vector::new));

      System.out.println(vector);*/
      /* Vector<HumanBeing> newCollection = h.getHumanBeings().stream()
               .sorted((o1,o2) -> -o1.getName().compareTo(o2.getName())).collect(Collectors.toCollection(Vector::new));
        System.out.println(newCollection);*/
        Collections.reverse(h.getHumanBeings());
        return "Отсортировано!";
    }

}
