package br.com.github.davimc.ItSupport.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(Long id, Class clazz) {
        super("Id: "+ id + " não encontrado para a classe " + clazz.getSimpleName());
    }
}
