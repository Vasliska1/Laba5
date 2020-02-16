package com.company.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    private Long x; //Значение поля должно быть больше -671, Поле не может быть null

    private Float y; //Максимальное значение поля: 649, Поле не может быть null

    public Coordinates(Long x, Float y) {
        this.x = x;
        this.y = y;
    }

    Coordinates() {
    }

    public Long getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {

        return "[x=" + this.getX() + ", y=" + this.getY() + "]";
    }

}
