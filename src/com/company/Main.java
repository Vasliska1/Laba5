package com.company;
import javax.xml.bind.*;
import java.io.IOException;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.Vector;


public class Main {
    public static final String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\file.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        Scanner in = new Scanner(new File(file));
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());

        HumanBeing h1 = new HumanBeing("z", new Coordinates(new Long(5), new Float(6)), true, true,
                new Long(5), WeaponType.HAMMER, Mood.SADNESS, new Car("x"));
        HumanBeing h2 = new HumanBeing("a", new Coordinates(new Long(5), new Float(6)), true, true,
                new Long(5), WeaponType.HAMMER, Mood.SADNESS, new Car("x"));

        HumanBeingCollection humansBeingCollection = new HumanBeingCollection(new Vector<>());
        humansBeingCollection.getHumanBeings().add(h1);
        humansBeingCollection.getHumanBeings().add(h2);


        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(humansBeingCollection, writer);


        marshaller.marshal(humansBeingCollection, new File(file));
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection hbs = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));

        for (HumanBeing hb : hbs.getHumanBeings())
            System.out.println(hb.toString());

        Command c = new Command();
        c.App(humansBeingCollection);
        for (HumanBeing hb : hbs.getHumanBeings())
            System.out.println(hb.toString());

//scanner.close();
    }


}