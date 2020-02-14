package com.company;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private CollectionAdmin admin;
    private String fullInputCommand;

    public App(CollectionAdmin admin) {
        this.admin = admin;
        this.fullInputCommand = "";
    }

    public void begin() {
        System.out.println("Здравствуйте! Введите help для просмотра возможных команд");
        try (Scanner command = new Scanner(System.in)) {
            while (!fullInputCommand.equals("exit")) {
                fullInputCommand = command.nextLine();
                this.admin.doCommand(fullInputCommand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
