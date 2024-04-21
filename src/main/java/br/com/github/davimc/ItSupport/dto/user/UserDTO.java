package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.Contact;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.dto.contact.ContactDTO;

import java.util.List;
import java.util.UUID;

public record UserDTO(UUID id, String name) {

    public UserDTO(User obj){
        this(obj.getId(), obj.getName());

    }
}
