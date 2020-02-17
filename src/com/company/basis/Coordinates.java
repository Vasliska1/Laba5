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

   /* public void getX(Long x) {

        try {
            if (x == null)
                throw new NullException("X");
            else if (x < -671)
                throw new InncorrectValue("X должен быть больше -671");
            this.x = x;

        } catch (NullException ex) {
            ex.getMessage();
        }
        catch (InncorrectValue e){
            e.getMessage();
        }
    }


    public String setY(Float y) {

        try {
            if (y == null)
                throw new NullException("y");
            else if (y > 649)
                throw new InncorrectValue("y должен быть меньше 649");
            this.y = y;
            return "";

        } catch (InncorrectValue inncorrectValue) {
            return inncorrectValue.getMessage();
        } catch (NullException e) {
           return e.getMessage();
        }

    }*/
}


