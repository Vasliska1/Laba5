package com.company.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * считывает комманды с файла
 */
public class FileInput implements IOInterface {

    public FileInput(String fileName) throws FileNotFoundException {
        try {


            String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + fileName;
            //String file = Paths.get(fileName).toAbsolutePath().toString();

            this.in = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("vi nub");
        }
    }

    private Scanner in;
    private String fileLine;

    @Override
    public String getNextInput() {

        if (in.hasNext()) {
            fileLine = in.nextLine().toLowerCase();
            System.out.println(fileLine);
            return fileLine;
        } else
            return null;


    }

    @Override
    public String getCurrentInput() {
        return fileLine;
    }

    @Override
    public void output(String message) {

    }

    @Override
    public Float getNextFloatInput() {
        return in.nextFloat();
    }

    @Override
    public Long getNextLongInput() {
        return in.nextLong();
    }
}
