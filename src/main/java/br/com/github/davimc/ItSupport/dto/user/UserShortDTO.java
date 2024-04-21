package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;

import java.util.UUID;

public record UserShortDTO(UUID id, String name) {
    public UserShortDTO(User obj) {
        this(obj.getId(), obj.getName());
    }
}
