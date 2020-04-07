package com.company.input;

import com.company.input.IOInterface;

import java.util.Scanner;

/**
 * считывает команды с клавиатуры
 */
public class TerminalInput implements IOInterface {
    private String currentInput;

    @Override
    public String getNextInput() {
        Scanner sc = new Scanner(System.in);
        currentInput = sc.nextLine().trim();
        return currentInput;
    }

    @Override
    public String getCurrentInput() {
        return currentInput;
    }

    @Override
    public void output(String message) {
        System.out.println(message);
    }

    @Override
    public Float getNextFloatInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    @Override
    public Long getNextLongInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }
}
