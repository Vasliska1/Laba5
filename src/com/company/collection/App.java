package com.company.collection;
import com.company.input.TerminalInput;

import java.io.IOException;

public class App {

    private CollectionAdmin admin;
    private String fullInputCommand;

    public App(CollectionAdmin admin) {
        this.admin = admin;
        this.fullInputCommand = "";
    }

    public void begin() throws IOException {
        TerminalInput terminal = new TerminalInput();

        terminal.output("Здрарова! Введите help для просмотра возможных команд");

            while (!terminal.getNextInput().equals("exit")) {

                this.admin.doCommand(terminal);
            }


    }
}
