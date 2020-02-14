package com.company;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;


@XmlRootElement(name = "humanbeing")
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanBeing {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @XmlJavaTypeAdapter(value = LocalDate1.class)
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Long impactSpeed; //Поле может быть null
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null


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

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public HumanBeing(String name, Coordinates coordinates,
                      Boolean realHero, boolean hasToothpick, Long impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = (int) (Math.random() * 100);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
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

@XmlAccessorType(XmlAccessType.FIELD)
class Car {
    private String name; //Поле может быть null

    Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
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

class LocalDate1 extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}