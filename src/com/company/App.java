package com.company;


import com.company.collection.CollectionManager;
import com.company.collection.CommandHandler;
import com.company.collection.CommandReader;
import com.company.collection.HumanBeingCollection;
import com.company.input.TerminalInput;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class App {

    private CommandReader reader;
    private CommandHandler handler;
    public void begin(String file) throws JAXBException, IOException {

        Scanner in = new Scanner(new File(file));
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));
        humanBeingCollection.setDate(new Date());
        handler = new CommandHandler(humanBeingCollection);
        TerminalInput terminal = new TerminalInput();
        System.out.println(humanBeingCollection.toString());
        terminal.output("Здарова! Введите help для просмотра возможных команд");
        while (!terminal.getNextInput().equals("exit")) {
            handler.doCommand(terminal);
        }
    }
}
