package com.company.server;

import com.company.commands.ExecuteScript;
import com.company.commands.Save;
import com.company.exception.NoCorrectValue;
import com.company.exception.NullValueException;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.NoSuchElementException;



public class ServerStarted {
    public static void main(String[] args) throws JAXBException, IOException, NullValueException, NoCorrectValue {
        String file = Paths.get(args[0]).toAbsolutePath().toString();
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("serverok zarabotal");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Клиент подключился к серверу.");
                Server s = new Server(clientSocket);
                s.runProgram();
                clientSocket.close();
                System.out.println("клиент отключился");
            }
        } catch (IOException ex) {
            System.err.println("IO problems");

        } catch (NoCorrectValue | NullValueException | ClassNotFoundException noCorrectValue) {
            noCorrectValue.printStackTrace();
        } catch (JAXBException e) {
            System.err.println("Ошибочка, сязанная с json");
        }catch (NoSuchElementException e){
            Save save = new Save();
            save.execute(new Server().getServerCollection(), file);
        }

    }


}