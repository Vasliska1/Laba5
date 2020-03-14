package com.company.commands;

import com.company.collection.CollectionManager;
import com.company.collection.CommandHandler;
import com.company.collection.HumanBeingCollection;
import com.company.exception.IncorrectValue;
import com.company.input.FileInput;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ExecuteScript extends AbstractCommands {
    public ExecuteScript(HumanBeingCollection collection) {
        super(collection);
    }
//Нужно связать с дукоманд
    @Override
    public String execute(String fileName) throws JAXBException, IOException {
        CommandHandler handler = new CommandHandler(getCollection(), file);
        FileInput input = new FileInput(fileName);
       /* try {
            while (input.getNextInput() != null) {
                if (input.getCurrentInput().equals("execute_script " + fileName))
                    throw new IncorrectValue("Не зацикливай меня(((");
                 handler.doCommand(input);
            }
        } catch (IncorrectValue e) {
            e.getMessage();
        }*/
       return null;
    }
}
