package com.company.collection;

import com.company.basis.HumanBeing;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 *
 */
@XmlRootElement(name = "humanbeings")
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanBeingCollection {

    @XmlElement(name = "humanbeing")
    public Vector<HumanBeing> humanBeing;
    private Date date;

    public Vector<HumanBeing> getHumanBeings() {

        return humanBeing;
    }

    public Vector<HumanBeing> getCollection() {
        return this.humanBeing;
    }

    public HumanBeingCollection(Vector<HumanBeing> humanBeing) {
        this.humanBeing = humanBeing;
        this.date = new Date();
    }

    public HumanBeingCollection() {

    }

    @Override
    public String toString() {
        return "Тип коллекции: " + this.getCollection().getClass() +
                "\nДата инициализации: " + date +
                "\nКоличество элементов: " + this.getCollection().size();
    }


    public void setDate(Date date) {
        this.date = date;
    }
}