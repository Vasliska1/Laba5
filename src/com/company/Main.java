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
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);

        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));
        humanBeingCollection.setDate(new Date());
        CollectionAdmin a = new CollectionAdmin(humanBeingCollection);
        App app = new App(a);
        app.begin();

/*for (HumanBeing hb : humansBeingCollection.getHumanBeings())
System.out.println(hb.toString());*/
    }
}
