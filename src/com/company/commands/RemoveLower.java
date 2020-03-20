package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class RemoveLower extends AbstractCommands {

    @Override
    public String execute(HumanBeingCollection h,IOInterface c) throws JAXBException, IOException {
        ReadElement r = new ReadElement();
        HumanBeing human = r.readElement(c);
        for (int i = 0; i < h.getHumanBeings().size(); i++) {
            if (h.getHumanBeings().get(i).compareTo(human) == -1) {
                h.getHumanBeings().remove(i);
            }
        }
        return "Успешно удалено!";

    }
}
