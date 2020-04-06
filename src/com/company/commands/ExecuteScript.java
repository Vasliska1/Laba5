package com.company.commands;

import com.company.collection.CommandHandler;
import com.company.collection.HumanBeingCollection;
import com.company.exception.IncorrectValue;
import com.company.input.FileInput;
import com.company.input.IOInterface;
import com.company.server.Server;
import com.company.server.ServerStarted;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript extends AbstractCommands {
    private String fileName;
    private Socket socket;
    private String line;

    public ExecuteScript(String fileName) {
        this.fileName = fileName;

    }
    public void getSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String execute(HumanBeingCollection h, IOInterface c) throws JAXBException, IOException {

        fileName = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\" + fileName;
        System.out.println(fileName);
        FileInput input = new FileInput(fileName);

        System.out.println(123);
        List<String> lines = new ArrayList<String>();
        while ((line = input.getNextInput()) != null) {
            lines.add(line);
            System.out.println(line);
        }
        System.out.println(1);
        System.out.println(lines);
        System.out.println(1);
        OutputStream writer = socket.getOutputStream();
        writer.write(lines.toString().getBytes());
           /* while (input.getNextInput() != null) {
                String CommandsInput = input.getNextInput();
                if (input.getCurrentInput().equals("execute_script " + fileName))
                    throw new IncorrectValue("Не зацикливай меня(((");
                System.out.println(12345);
                OutputStream writer = socket.getOutputStream();
                writer.write(input.getNextInput().getBytes());
            }*/
        return null;
    }

}
