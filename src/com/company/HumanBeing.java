package com.company;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "cat")

public class HumanBeing  {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Long impactSpeed; //Поле может быть null
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null
public LocalDate getLocalDate() {
        return creationDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.creationDate = localDate;
    }


    public HumanBeing() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getImpactSpeed() {
        return impactSpeed;
    }

    public HumanBeing(Integer id, String name, Coordinates coordinates, LocalDate creationDate,
                      Boolean realHero, boolean hasToothpick, Long impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }
    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", weaponType=" + weaponType +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }

}
@XmlAccessorType(XmlAccessType.FIELD)
class Coordinates {

    private Long x; //Значение поля должно быть больше -671, Поле не может быть null

    private Float y; //Максимальное значение поля: 649, Поле не может быть null

    public Coordinates(Long x, Float y) {
        this.x = x;
        this.y = y;
    }
    Coordinates(){}

    public Long getX() {
        return x;
    }

    public Float getY() {
        return y;
    }
    @Override
    public String toString() {

            return " [x=" + this.getX() + ", y=" + this.getY() + "]";
        }


}
@XmlAccessorType(XmlAccessType.FIELD)
class Car {
    Car(){}
    private String name; //Поле может быть null

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum WeaponType {
    HAMMER,
    RIFLE,
    MACHINE_GUN,
    BAT;
}

enum Mood {
    SADNESS,
    APATHY,
    CALM,
    FRENZY;
}
