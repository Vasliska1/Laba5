package com.company;

public class HumanBeing {


    public Integer getId() {
        return id;
    }

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
    HumanBeing(){

    }
}
class Coordinates {
    private Long x; //Значение поля должно быть больше -671, Поле не может быть null
    private Float y; //Максимальное значение поля: 649, Поле не может быть null
}
class Car {
    private String name; //Поле может быть null
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

