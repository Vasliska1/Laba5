package com.company;

import com.company.basis.HumanBeing;
import com.company.basis.WeaponType;
import com.company.collection.CommandHandler;
import com.company.collection.CommandReader;
import com.company.collection.HumanBeingCollection;
import com.company.exception.*;
import com.company.input.TerminalInput;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

/**
 * Собирает коллекцию из файла
 */
public class App {

    private CommandReader reader;
    private CommandHandler handler;

    public void begin(File file) throws NoCorrectValue, NullValueException, JAXBException, IOException, NoArgument, IncorrectValue, FileNotFoundException {

        Scanner in = new Scanner(file);
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(file);

        for (HumanBeing hb : humanBeingCollection.getHumanBeings()) {


            if (hb.getName().trim().equals("")) throw new NullValueException("name"); //работает
            if (hb.getCoordinates().getX() == null) throw new NullValueException("x"); //работает
            if (hb.getCoordinates().getY() == null) throw new NullValueException("y"); //работает
            if (hb.getCoordinates().getY() > 649) throw new NoCorrectValue("Максимальное значение поля y - 649");
            if (hb.getCoordinates().getX() < -671) throw new NoCorrectValue("X должен быть больше -671"); //работает
            if (hb.getCreationDate() == null) throw new NullValueException("date"); //работает
            if (hb.getRealHero() == null) throw new NullValueException("RealHero"); //работает
            if (hb.getId() <= 0) throw new NoCorrectValue("Id should be > 0"); //работает
        }

        humanBeingCollection.setDate(new Date());
        handler = new CommandHandler(humanBeingCollection, file.toString());
        TerminalInput terminal = new TerminalInput();

        terminal.output("Здарова! Введите help для просмотра возможных команд");
        while (!terminal.getNextInput().equals("exit")) {
            handler.doCommand(terminal);
        }
    }
}
