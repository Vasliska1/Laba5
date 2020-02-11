package com.company;

import com.company.HumanBeing;


import javax.xml.bind.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws JAXBException {

        HumanBeing h1 = new HumanBeing(7, "z", new Coordinates(new Long(5), new Float(6)),
                LocalDate.now(), true, true,
                new Long(5), WeaponType.HAMMER, Mood.SADNESS, new Car("x"));

        Vector<HumanBeing> human = new Vector();
        human.add(h1);
        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeing.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(h1, writer);
        String result = writer.toString();
        System.out.println(result);

        String xmldata = "<humanBeing><id>7</id><name>z</name>" +
                "<coordinates><x>5</x><y>6.0</y><creationDate>2020-01-01</creationDate>" +
                "</coordinates><realHero>true</realHero><hasToothpick>true</hasToothpick><impactSpeed>9</impactSpeed>" +
                "<weaponType>HAMMER</weaponType><mood>SADNESS</mood><car><name>xvvv</name></car></humanBeing>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context2 = JAXBContext.newInstance(HumanBeing.class);
        Unmarshaller unmarshaller = context2.createUnmarshaller();

        HumanBeing h2 = (HumanBeing) unmarshaller.unmarshal(reader);
        System.out.println(h2.toString());
    }
}