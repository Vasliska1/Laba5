package com.company;

import com.company.App;
import com.company.collection.CollectionManager;
import com.company.collection.CommandHandler;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class Main {
   //public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml" ;

    public static void main(String[] args) throws JAXBException, IOException {
        final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + args[0]; throw new NullPointerException("Вы обосрались");


        App app = new App();
        app.begin(file);

/*for (HumanBeing hb : humansBeingCollection.getHumanBeings())
System.out.println(hb.toString());*/
    }
}
