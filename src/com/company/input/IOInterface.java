package com.company.input;

public interface IOInterface {
    String getNextInput();
    String getCurrentInput();
    void output(String message);
    Float getNextFloatInput();
    Long getNextLongInput();
}
