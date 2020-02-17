package com.company.exception;

public class NullException extends Exception {
    public NullException(String str) {
        super(str + " нaлом быть не можеt");
    }
}

