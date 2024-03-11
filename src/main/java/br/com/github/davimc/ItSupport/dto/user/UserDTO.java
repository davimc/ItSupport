package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.Contact;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.dto.contact.ContactDTO;

import java.util.List;
import java.util.UUID;

public record UserDTO(UUID id, String name, String endereco, String cpf, List<ContactDTO> contacts) {

    public UserDTO(User obj, List<Contact> contacts){
        this(obj.getId(), obj.getName(), obj.getAddress(), obj.getCpf(), contacts.stream().map(ContactDTO::new).toList());

    }
}
