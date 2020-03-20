package com.company.server;

import com.company.commands.*;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //public static final String file = "C:\\Users\\Владислава\\Desktop\\Laba5-master\\out\\production\\Laba5\\com\\company\\file.xml";

    public void startWork() throws IOException, ClassNotFoundException {
        System.out.println(1);
        Scanner scanner = new Scanner(System.in);
        System.out.println(22);
        Socket clientSocket = new Socket("127.0.0.1", 8000);
        System.out.println(2);
        while (true) {
            System.out.println(3);

            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println(4);
            System.out.println((String) reader.readObject());
            Scanner sc = new Scanner(System.in);
            String[] rightCommand = sc.nextLine().trim().split(" ", 2);
          //  ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());


            while (!rightCommand[0].equals("exit")) {
                this.getObjectCommand(rightCommand, clientSocket);

                //  this.getObjectCommand(rightCommand,clientSocket);
                // writer.writeObject(this.getObjectCommand(rightCommand));
                System.out.println((String) reader.readObject());
                rightCommand = sc.nextLine().trim().split(" ", 2);

            }
            //writer.close();
            reader.close();
            clientSocket.close();

        }

    }


    public void getObjectCommand(String[] rightCommand, Socket clientSocket) throws IOException {
        ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
        AbstractCommands objectCommands = new AbstractCommands();
        System.out.println(rightCommand[0]);
        switch (rightCommand[0]) {
            case "help":
                objectCommands = new Help();
                break;
            case "info":
                objectCommands = new Info();
                break;
            case "show":
                objectCommands = new Show();
                break;
            case "add":
                objectCommands = new Add();
                break;
            case "update":
                objectCommands = new Update(rightCommand[1]);
                break;
            case "remove_by_id":
                objectCommands = new RemoveById(Integer.parseInt(rightCommand[1]));

                break;
            case "clear":
                objectCommands = new Clear();
                break;

            case "save":
                objectCommands = new Save();
                break;
            case "execute_script":
                objectCommands = new ExecuteScript(rightCommand[1]);
                break;
            case "remove_lower":
                objectCommands = new RemoveLower();
                break;
            case "reorder":
                objectCommands = new Reorder();
                break;
            case "sort":
                objectCommands = new Sort();
                break;
            case "sum_of_impact_speed":
                objectCommands = new SumOfImpactSpeed();
                break;
            case "filter_starts_with_name":
                objectCommands = new FilterStartsWithName();
                break;
            case "print_field_descending_weapon_type":
                objectCommands = new PrintFieldDescendingWeaponType();
                break;

        }
        System.out.println(objectCommands);
        writer.writeObject(objectCommands);

        // return objectCommands;
    }
}