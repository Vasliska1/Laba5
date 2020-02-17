package com.company;

import com.company.App;
import com.company.collection.CollectionManager;
import com.company.collection.CommandHandler;
import com.company.collection.HumanBeingCollection;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class Main {
   public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml" ;

    public static void main(String[] args) throws JAXBException, IOException {
      //  try {

        //    final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + args[0];


        App app = new App();
        app.begin(file);

       /* }
        catch (NullPointerException e){
            System.out.println("Vi obosralis");
        }
*/
/*for (HumanBeing hb : humansBeingCollection.getHumanBeings())
System.out.println(hb.toString());*/
    }
}
