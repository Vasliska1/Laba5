package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;

public class Update extends AbstractCommands {
    private HumanBeing human;
    private Integer id;

    public Update(int id, HumanBeing human) {
        this.id = id;
        this.human = human;
    }


    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {

        Vector<HumanBeing> newCollection = h.getHumanBeings().stream().filter(s -> (s.compareTo(human) != -1)).
                collect(Collectors.toCollection(Vector::new));
        if (newCollection.size() == h.getHumanBeings().size()) {
            return "Такого id нет";
        }
        h.getHumanBeings().clear();
        h.getHumanBeings().addAll(newCollection);

        return "Успешно удалено!";
    }
}