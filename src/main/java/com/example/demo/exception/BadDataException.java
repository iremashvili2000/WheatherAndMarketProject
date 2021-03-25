package com.example.demo.exception;

public class BadDataException extends RuntimeException{
    protected String from;

    public BadDataException(){
    }

    public BadDataException(String form , String message) {
        super(message);
        this.from = form;
    }
    public BadDataException(String message){
        super(message);
    }

    public String getFrom() {
        return from;
    }
}
