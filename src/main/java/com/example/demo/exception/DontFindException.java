package com.example.demo.exception;

public class DontFindException extends RuntimeException{
    protected String from;

    public DontFindException(){
    }

    public DontFindException(String form , String message) {
        super(message);
        this.from = form;
    }
    public DontFindException(String message){
        super(message);
    }

    public String getFrom() {
        return from;
    }
}
