package com.company.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * считывает комманды с файла
 */
public class FileInput implements IOInterface {
    public FileInput(String fileName) throws FileNotFoundException {

        String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\" + fileName;
        this.in = new Scanner(new File(file));
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
