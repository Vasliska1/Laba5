package com.company.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@XmlRootElement(name = "humanbeing")
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanBeing implements Comparable<com.company.basis.HumanBeing> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @XmlJavaTypeAdapter(value = WeDontKnowHowCallIt_Puzirek_V_Nashem_Serdce_Navsegda.class)
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
        this.id = (int) (Math.random() * 1000);
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

    @Override
    public int compareTo(com.company.basis.HumanBeing anotherHuman) {
        if (this.impactSpeed == anotherHuman.impactSpeed) {
            return 0;
        } else if (this.impactSpeed > anotherHuman.impactSpeed) {
            return 1;
        } else {
            return -1;
        }
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

   /* public String setRealHero(Boolean realHero) {
        try {
            if (realHero.equals(""))
                throw new NullException("realHero");
            this.realHero = realHero;
            return "";
        } catch (NullException e) {
            return e.getMessage();
        }
    }

     public String setHasToothpick (boolean hasToothpick){
            try {
                if (realHero.equals(""))
                    throw new NullException("hasToothpick");
                this.hasToothpick = hasToothpick;
                return "";
            } catch (NullException e) {
                return e.getMessage();
            }

        }

        public String setImpactSpeed (Long impactSpeed){
            try {
                if (realHero.equals(""))
                    throw new NullException("impactSpeed");
                this.impactSpeed = impactSpeed;
                return "";
            } catch (NullException e) {
                return e.getMessage();
            }


        }

        public void setWeaponType (WeaponType weaponType){
            this.weaponType = weaponType;
        }

        public void setMood (Mood mood){
            this.mood = mood;
        }

        public void setCar (Car car){
            this.car = car;
        }

*/

}

