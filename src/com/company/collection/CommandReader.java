package com.company.collection;

import com.company.input.IOInterface;

public class CommandReader {

    public String[] returnCommand(IOInterface inputCommand){
        return inputCommand.getCurrentInput().toLowerCase().trim().split(" ",2);
    }
    //rightCommand = inputCommand.getCurrentInput().toLowerCase().trim().split(" ", 2);
}
