package com.example.demo.exception;

import java.io.IOException;

public class StorageException extends RuntimeException{
    protected String from;

    public StorageException(){
    }

    public StorageException(String form , String message) {
        super(message);
        this.from = form;
    }
    public StorageException(String message){
        super(message);
    }

    public StorageException(String form, IOException e) {
    }

    public String getFrom() {
        return from;
    }

}
