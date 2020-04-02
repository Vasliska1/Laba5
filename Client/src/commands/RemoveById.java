package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

public class RemoveById extends AbstractCommands {
    private Integer id;
public RemoveById(int id){
    this.id = id;
}
    @Override
    public String execute(HumanBeingCollection h,IOInterface c){
        int k = 0;
        for (int i = 0; i < h.getHumanBeings().size(); i++) {
            if (h.getHumanBeings().get(i).getId().toString().equals(id)) {
                k++;
            }
        }
        if (k > 0) {
            for (int i = 0; i < h.getHumanBeings().size(); i++) {
                if (h.getHumanBeings().get(i).getId().toString().equals(id)) {
                    h.getHumanBeings().remove(i);
                }
            }
            return "Элемент коллекции удалён.";
        } else return "Такого id нет";

    }
}
