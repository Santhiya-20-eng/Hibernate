package com.hibernate.crud.exceptions;

public class DuplicateOwnerFoundException extends Exception{
    public DuplicateOwnerFoundException(String message){
        super(message);
    }
}