package com.company;

import com.company.collection.CollectionManager;
import com.company.exception.IncorrectValue;
import com.company.exception.NoArgument;
import com.company.exception.NoCorrectValue;
import com.company.exception.NullValueException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
  // public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml" ;

    public static void main(String[] args) throws NullValueException, IOException, NoCorrectValue, NoArgument, IncorrectValue, JAXBException {
      //  try {
       String file = Paths.get(args[0]).toAbsolutePath().toString();


       // final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + args[0];

        CollectionManager filePath = new CollectionManager(file);
        
        App app = new App();
        app.begin(file);

       /* }
        catch (
    IOException e){
            System.out.println("Vi obosralis");
        }
*/
/*for (HumanBeing hb : humansBeingCollection.getHumanBeings())
System.out.println(hb.toString());*/
    }
}
