package com.company.server;

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
           ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
           ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
           System.out.println(4);
           while (!(scanner.nextLine()).equals("exit")){
               System.out.println(5);
               outputStream.writeObject(scanner.nextLine());
               System.out.println(inputStream.readObject());
           }


       }




       /*


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        writer.write("execute command");
        writer.newLine();
        writer.flush();

        System.out.println(reader.readLine());

        System.out.println(reader.readLine());

        writer.close();
        reader.close();
        clientSocket.close();


    }
    */

}}
