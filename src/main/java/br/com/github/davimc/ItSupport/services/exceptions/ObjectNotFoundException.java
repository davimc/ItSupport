package br.com.github.davimc.ItSupport.services.exceptions;

import br.com.github.davimc.ItSupport.entities.User;

import java.util.UUID;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(UUID id, Class clazz) {
        super("Id: " + id + " not found for " + clazz.getSimpleName() + " class ");
    }

    public ObjectNotFoundException(String name, Class clazz) {
        super("Username: " + name + " not found for " + clazz.getSimpleName() + " class ");
    }


}
