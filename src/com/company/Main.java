package com.company;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class Main {
    public static final String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\file.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        Scanner in = new Scanner(new File(file));
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());

        HumanBeing h1 = new HumanBeing("zannn", new Coordinates(new Long(5), new Float(6)), true, true,
                new Long(5), WeaponType.RIFLE, Mood.SADNESS, new Car("x"));
        HumanBeing h2 = new HumanBeing("awww", new Coordinates(new Long(5), new Float(6)), true, true,
                new Long(7), WeaponType.BAT, Mood.SADNESS, new Car("x"));
        HumanBeing h4 = new HumanBeing("fort", new Coordinates(new Long(5), new Float(6)), true, true,
                new Long(8), WeaponType.HAMMER, Mood.SADNESS, new Car("x"));
        HumanBeingCollection humansBeingCollection = new HumanBeingCollection(new Vector<>());
        humansBeingCollection.getHumanBeings().add(h1);
        humansBeingCollection.getHumanBeings().add(h2);
        humansBeingCollection.getHumanBeings().add(h4);

        StringWriter writer = new StringWriter();
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal(humansBeingCollection, writer);
        marshaller.marshal(humansBeingCollection, new File(file));


        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection hbs = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));

        CollectionAdmin a = new CollectionAdmin(humansBeingCollection);
        App app=new App(a);
        app.begin();

        /*for (HumanBeing hb : humansBeingCollection.getHumanBeings())
            System.out.println(hb.toString());*/
    }

}