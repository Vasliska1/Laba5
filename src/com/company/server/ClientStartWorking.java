package com.company.server;

import java.io.IOException;

public class ClientStartWorking {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("zapysk klienta");
        Client connection = new Client();

        connection.startWork();
    }
}
