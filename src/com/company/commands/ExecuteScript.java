package com.company.commands;

import com.company.collection.CommandHandler;
import com.company.collection.HumanBeingCollection;
import com.company.exception.IncorrectValue;
import com.company.input.FileInput;
import com.company.input.IOInterface;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ExecuteScript extends AbstractCommands {
private String fileName;
private Socket clientSocket;

    public ExecuteScript(String fileName) {
        this.fileName = fileName;

    }
    public ExecuteScript(Socket clientSocket){
        this.clientSocket =clientSocket;
    }

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {
        CommandHandler handler = new CommandHandler(h, file);
        FileInput input = new FileInput(fileName);
       try {
           ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            while (input.getNextInput() != null) {
                if (input.getCurrentInput().equals("execute_script " + fileName))
                    throw new IncorrectValue("Не зацикливай меня(((");

                writer.writeObject(input);
            }
        } catch (IncorrectValue e) {
            e.getMessage();
        }
       return null;
    }
}
