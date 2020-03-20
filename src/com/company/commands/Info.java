package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

public class Info extends AbstractCommands {


    @Override
    public String execute(HumanBeingCollection h, IOInterface c) {
        return h.toString();
    }
}
