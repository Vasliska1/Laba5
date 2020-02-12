package com.company;

import com.company.HumanBeing;


import javax.xml.bind.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static final String FILE_PATH = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml";

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
// try {
        Scanner in = new Scanner(new File(FILE_PATH));
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
//System.out.println(data.toString().replaceAll(" ", ""));
//} catch (Exception ex) {
// ex.printStackTrace();
//}

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

//Scanner fileScanner = new Scanner(new FileReader(dat.xml));

/*String xmldata = "<humanBeing><id>7</id><name>z</name>" +
"<coordinates><x>5</x><y>6.0</y><creationDate>2020-01-01</creationDate>" +
"</coordinates><realHero>true</realHero><hasToothpick>true</hasToothpick><impactSpeed>9</impactSpeed>" +
"<weaponType>HAMMER</weaponType><mood>SADNESS</mood><car><name>xvvv</name></car></humanBeing>";*/
/*
String xmldata="<humanBeing>\n" +
" <id>7</id>\n" +
" <name>z</name>\n" +
" <coordinates>\n" +
" <x>5</x>\n" +
" <y>6.0</y>\n" +
" </coordinates>\n" +
" <creationDate>2020-01-01</creationDate>\n" +
" <realHero>true</realHero>\n" +
" <hasToothpick>true</hasToothpick>\n" +
" <impactSpeed>5</impactSpeed>\n" +
" <weaponType>HAMMER</weaponType>\n" +
" <mood>SADNESS</mood>\n" +
" <car>\n" +
" <name>x</name>\n" +
" </car>\n" +
"</humanBeing>";*/
        String xmldata = data.toString().replaceAll(" ", "");
        System.out.println(xmldata);
        StringReader reader = new StringReader(xmldata);

        JAXBContext context2 = JAXBContext.newInstance(HumanBeing.class);
        Unmarshaller unmarshaller = context2.createUnmarshaller();

        HumanBeing h2 = (HumanBeing) unmarshaller.unmarshal(reader);
        System.out.println(h2.toString());
    }
}