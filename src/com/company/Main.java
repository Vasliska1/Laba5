package com.company;

import com.company.exception.NullValueException;

import java.io.IOException;

public class Main {
   public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml" ;

    public static void main(String[] args) throws Exception, NullValueException {
      //  try {

        //    final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + args[0];


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
