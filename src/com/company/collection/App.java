package com.company.collection;


import com.company.basis.HumanBeing;
import com.company.collection.CommandHandler;
import com.company.collection.CommandReader;
import com.company.collection.HumanBeingCollection;
import com.company.exception.IncorrectValue;
import com.company.exception.NoCorrect;
import com.company.exception.NullException;
import com.company.input.TerminalInput;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class App {

    private CommandReader reader;
    private CommandHandler handler;

    public void begin(String file) throws Exception {

        Scanner in = new Scanner(new File(file));
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));

        for (HumanBeing hb : humanBeingCollection.getHumanBeings()) {
            try {
                if (hb.getCoordinates().getY() > 649) throw new NoCorrect("y должен быть меньше 649");
                if (hb.getName().equals("")) throw new NullException("name");
                if (hb.getCoordinates().getX() == null) throw new NullException("x");
                if (hb.getCoordinates().getY() == null) throw new NullException("y");
                if (hb.getCoordinates().getX() < -671) throw new NoCorrect("X должен быть больше -671");
                if (hb.getCreationDate() == null) throw new NullException("date");
                if (hb.getRealHero() == null) throw new NullException("RealHero");
                if(hb.getId()<0) throw new NoCorrect("Id should be >0");
            } catch (NoCorrect | NullPointerException e) {
                e.getMessage();
            }

        }
        humanBeingCollection.setDate(new Date());
        handler = new CommandHandler(humanBeingCollection);
        TerminalInput terminal = new TerminalInput();

        terminal.output("Здарова! Введите help для просмотра возможных команд");
        while (!terminal.getNextInput().equals("exit")) {
            handler.doCommand(terminal);
        }
    }
}
