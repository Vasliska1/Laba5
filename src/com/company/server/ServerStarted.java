package com.company.server;

import com.company.exception.NoCorrectValue;
import com.company.exception.NullValueException;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.company.server.Server.buildCollection;

public class ServerStarted {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);

            while (true) {

                Socket clientSocket = server.accept();
                System.out.println("Клиент подключился к серверу.");

                Server s = new Server(clientSocket);
                s.runProgram();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (NullValueException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (NoCorrectValue noCorrectValue) {
            noCorrectValue.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}