package com.sctp.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyTaskListException extends Exception{
    public EmptyTaskListException(String message){
        super(message);
    }
}
