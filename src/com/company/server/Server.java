package com.company.server;

import com.company.basis.HumanBeing;

import com.company.collection.HumanBeingCollection;
import com.company.commands.AbstractCommands;
import com.company.commands.*;
import com.company.exception.NoCorrectValue;
import com.company.exception.NullValueException;
import com.company.input.TerminalInput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class Server {

    private Socket incoming;
    public String file;
    private HumanBeingCollection serverCollection;

    Server(Socket incoming, String file) throws NoCorrectValue, NullValueException, JAXBException {
        this.incoming = incoming;
        this.file =file;

    }

    Server() throws NoCorrectValue, NullValueException, JAXBException {}

    public void runProgram() throws IOException, ClassNotFoundException, NoCorrectValue, NullValueException, JAXBException {
        try {
            serverCollection = buildCollection();
            OutputStream writer = incoming.getOutputStream();
            writer.write(new String("Здарова, православные. Введите help. ").getBytes());

            TerminalInput terminalInput = new TerminalInput();

            while (true) {
                ObjectInputStream reader = new ObjectInputStream(
                        incoming.getInputStream());

                AbstractCommands inputCommands = (AbstractCommands) reader.readObject();

                System.out.println(inputCommands);
                writer.write(inputCommands.execute(serverCollection, terminalInput).getBytes());

            }

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("chto-to s clientom");
        }

    }


    public HumanBeingCollection buildCollection() throws JAXBException, NullValueException, NoCorrectValue {
        File f = new File(file);
        if (!f.canRead() && !f.canWrite() && !f.canExecute())
            throw new SecurityException();

        Scanner in = new Scanner(file);
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));
        Collections.sort(humanBeingCollection.getHumanBeings());
        for (HumanBeing hb : humanBeingCollection.getHumanBeings()) {


            if (hb.getName().trim().equals("")) throw new NullValueException("name"); //работает
            if (hb.getCoordinates().getX() == null) throw new NullValueException("x"); //работает
            if (hb.getCoordinates().getY() == null) throw new NullValueException("y"); //работает
            if (hb.getCoordinates().getY() > 649)
                throw new NoCorrectValue("Максимальное значение поля y - 649");
            if (hb.getCoordinates().getX() < -671)
                throw new NoCorrectValue("X должен быть больше -671"); //работает
            if (hb.getCreationDate() == null) throw new NullValueException("date"); //работает
            if (hb.getRealHero() == null) throw new NullValueException("RealHero"); //работает
            if (hb.getId() <= 0) throw new NoCorrectValue("Id should be > 0"); //работает
        }

        humanBeingCollection.setDate(new Date());
      /*  for (HumanBeing humanBeing : humanBeingCollection.getHumanBeings()) {
            System.out.println(humanBeing);

        }*/
        return humanBeingCollection;

    }

    public HumanBeingCollection getServerCollection() {
        return serverCollection;
    }
}




