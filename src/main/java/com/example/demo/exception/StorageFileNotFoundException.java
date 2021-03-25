package com.example.demo.exception;

import java.net.MalformedURLException;

public class StorageFileNotFoundException extends RuntimeException{
    protected String from;

    public StorageFileNotFoundException(){
    }

    public StorageFileNotFoundException(String form , String message) {
        super(message);
        this.from = form;
    }
    public StorageFileNotFoundException(String message){
        super(message);
    }

    public StorageFileNotFoundException(String form, MalformedURLException e) {
    }

    public String getFrom() {
        return from;
    }
}
