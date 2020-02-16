package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput implements IOInterface{
public FileInput(String fileName) throws FileNotFoundException {
    String file = "C:\\Users\\Vasilisa\\Laba5\\out\\production\\Laba5\\com\\company\\" + fileName;
    this.in = new Scanner(new File(file));

}
private Scanner in;
private String fileLine;
    @Override
    public String getNextInput() {

        fileLine = in.next().toLowerCase();
        System.out.println(fileLine);
        return fileLine;

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
