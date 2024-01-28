package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.dto.contact.ContactDTO;

import java.util.List;
import java.util.UUID;

public record UserDTO(UUID id, String name, String endereco, String cpf, List<ContactDTO> contacts) {

    public UserDTO(User obj, List<ContactDTO> contacts){
        this(obj.getId(), obj.getName(), obj.getEndereco(), obj.getCpf(), contacts);

    }
}
