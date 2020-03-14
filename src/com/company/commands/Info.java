package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

public class Info extends AbstractCommands{
    public Info(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() {
        return getCollection().getHumanBeings().toString();
    }
}
