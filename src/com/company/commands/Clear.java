package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

public class Clear extends AbstractCommands {


    @Override
    public String execute(HumanBeingCollection h,IOInterface c) {
        h.getHumanBeings().clear();
        return "Коллекция очищена";
    }
}
