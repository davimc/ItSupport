package br.com.github.davimc.ItSupport.services.dto.user;

import br.com.github.davimc.ItSupport.entities.User;

import java.util.UUID;

public record UserShortDTO(UUID id, String name, String cpf) {
    public UserShortDTO(User obj) {
        this(obj.getId(), obj.getName(), obj.getCpf());
    }
}
