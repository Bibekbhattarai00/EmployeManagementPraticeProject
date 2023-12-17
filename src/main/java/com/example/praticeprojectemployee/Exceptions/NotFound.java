package com.example.praticeprojectemployee.Exceptions;

public class NotFound extends RuntimeException{
    String message;

    @Override
    public String toString() {
        return message;
    }
    public NotFound(String message) {
        this.message = message;
    }
    public NotFound(){
    message="Not found";
    }
}
