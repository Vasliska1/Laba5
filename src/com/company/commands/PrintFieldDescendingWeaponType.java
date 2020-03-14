package com.company.commands;

import com.company.basis.WeaponType;
import com.company.collection.CollectionManager;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class PrintFieldDescendingWeaponType extends  AbstractCommands{

    public PrintFieldDescendingWeaponType(HumanBeingCollection collection) {
        super(collection);
    }

    @Override
    public String execute() throws JAXBException, IOException {
        Vector<WeaponType> collection = new Vector<>();
        for (int i = 0; i < getCollection().getHumanBeings().size(); i++) {
            if (!(getCollection().getHumanBeings().get(i).getWeaponType() == null)) {
                collection.add(getCollection().getHumanBeings().get(i).getWeaponType());
            }
        }
        Comparator<WeaponType> comparator = Comparator.nullsFirst(Comparator.comparing(obj -> obj.power));
//        Comparator<WeaponType> comparator = Comparator.comparing(obj -> obj.power).thenComparing(Comparator.nullsFirst());
        Collections.sort(collection, comparator);
        Collections.reverse(collection);
        String result = null;
        for (WeaponType w : collection) {
           result = result + w.toString() + " ";
        }
    return result.toString();
    }
}
