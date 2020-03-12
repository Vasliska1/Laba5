package com.company;

import com.company.collection.CollectionManager;
import com.company.exception.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.NoSuchElementException;

public class Main {
  public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml";

    public static void main(String[] args) throws NullValueException, IOException, NoCorrectValue, NoArgument, IncorrectValue, JAXBException {
        try {

          //  String file = Paths.get(args[0]).toAbsolutePath().toString();
            File f = new File(file);
            if (!f.canRead() && !f.canWrite() && !f.canExecute())
                throw new SecurityException();

            App app = new App();
            app.begin(f);


        }
        catch(SecurityException e){
            System.out.println("vi nub");
        }
        catch (FileNotFoundException e) {
            System.out.println("vii nub");
        }catch(NoSuchElementException e){
            System.exit(0);
        }



      /*  String path = Paths.get(file).getParent().toString();

        System.out.println(path);


        File myFolder = new File(path);
        File[] files = myFolder.listFiles();
        int k = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].equals(file)) {
                k = 1;
                System.out.println(files[i]);
            }
        }*/





        //  if (k == 1) {
        //    throw new FileNotFoundException();
        //}
        //catch (IOException e){
        //  System.out.println("Vi obosralis");
        //}

        // } catch (FileNotFoundException permisionDenied) {
        //   System.out.println("ошибочка прав доступа");
        //}
  /*  public void processFilesFromFolder(File folder)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }
            // иначе вам попался файл, обрабатывайте его!
        }
    }*/

    }
}
