package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;

import java.util.UUID;

public record UserDTO(UUID id, String name) {

    public UserDTO(User obj){
        this(obj.getId(), obj.getName());

    }
}
