package com.company;
import java.io.*;
import java.net.*;


public class serv {


        public final static int PORT = 12345;

        public static void main(String[] a) {
            ServerSocket s;
            String tmp;
            try {
                s = new ServerSocket(serv.PORT);

                // Блокируем пока не произойдет соединение
                Socket socket = s.accept();

                // создаём Reader для чтения из порта
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));

                // создаём Writer для записи в порт
                PrintWriter out =
                        new PrintWriter(
                                new BufferedWriter(
                                        new OutputStreamWriter(
                                                socket.getOutputStream())), true);
                // здесь – диалог с клиентом
                out.println("Это отправляется клиенту");

                tmp = in.readLine();
                System.out.println("От клиента принята строка " + tmp);
                // закрываем соединение
                in.close();
                out.close();
            } catch (IOException ex) {
                System.out.println("Server socket error");
            }
        }
    }
