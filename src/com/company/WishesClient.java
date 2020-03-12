package com.company;

import java.io.*;
import java.net.*;
public class WishesClient {


        public static void main(String[] a) {
            Socket socket;
            try {
                // соединяемся с сервером
                socket = new Socket("localhost", serv.PORT);

                // создаём Reader для приёма данных от сервера
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                String str = in.readLine();
                System.out.println("Получено от сервера:" + str);

                // создаём Writer для отправки данных серверу
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream())), true);
                out.println("Client куйгуые ");

            } catch (UnknownHostException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
