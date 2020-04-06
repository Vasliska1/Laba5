package com.company.commands;

import com.company.basis.HumanBeing;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;
import com.company.input.IOInterface;

import java.util.Vector;
import java.util.stream.Collectors;

public class RemoveById extends AbstractCommands {
    private int id;
public RemoveById(int id){
    this.id = id;
}
    @Override
    public String execute(HumanBeingCollection h,IOInterface c){
        Vector<HumanBeing> newCollection = h.getHumanBeings().stream().filter(s -> s.getId() != id).
                collect(Collectors.toCollection(Vector::new));
        if (newCollection.size() == h.getHumanBeings().size()) {
            return "Такого id нет";
        }
       else{ h.getHumanBeings().clear();
        h.getHumanBeings().addAll(newCollection);
        return "Элемент коллекции удалён.";}


    }
}
