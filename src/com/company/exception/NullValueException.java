package com.company.exception;

public class NullValueException extends Throwable {
    public NullValueException(String s){
        super(s + " should be not null");
    }
}
