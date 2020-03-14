package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

public class RemoveById extends AbstractCommands {

    public RemoveById(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute(String id){
        int k = 0;
        for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
            if (getCollection().getHumanBeings().get(i).getId().toString().equals(id)) {
                k++;
            }
        }
        if (k > 0) {
            for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
                if (getCollection().getHumanBeings().get(i).getId().toString().equals(id)) {
                    getCollection().getHumanBeings().remove(i);
                }
            }
            return "Элемент коллекции удалён.";
        } else return "Такого id нет";

    }
}
