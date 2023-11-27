package com.sctp.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
        // for serialisation and deserialization process of objects (process of converting an object's state into byte stream/vice versa)
        // serialVersionVID - unique identifier associated with a serialised version of a class
        // used in maintaining compatibility between serialised objects and their class definitions
        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String message){
            super(message);
        }
}
