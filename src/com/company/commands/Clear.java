package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

public class Clear extends AbstractCommands {
    public Clear(HumanBeingCollection collection) {
        super(collection);

    }

    @Override
    public String execute() {

        getCollection().getHumanBeings().clear();
        return "Коллекция очищена";
    }
}
