package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.Role;
import br.com.github.davimc.ItSupport.entities.User;

import java.util.List;
import java.util.UUID;

public record UserTypifiedDTO(UUID id, String name, String document, List<String> type) {
    public UserTypifiedDTO(User obj) {
        this(obj.getId(), obj.getName(), obj.getDocument(), obj.getRoles().stream().map(Role::getAuthority).toList());
    }
}
