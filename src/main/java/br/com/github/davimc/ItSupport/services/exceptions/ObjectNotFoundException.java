package br.com.github.davimc.ItSupport.services.exceptions;

import java.util.UUID;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(UUID id, Class clazz) {
        super("Id: "+ id + " not found for"+ clazz.getSimpleName()+ " class ");
    }
}
