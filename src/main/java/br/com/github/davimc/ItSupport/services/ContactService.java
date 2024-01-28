package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.entities.Contact;
import br.com.github.davimc.ItSupport.repositories.ContactRepository;
import br.com.github.davimc.ItSupport.dto.contact.ContactDTO;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    protected Contact find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Contact.class));
    }

    public ContactDTO findById(UUID id) {
        return toDto(find(id));
    }
    public Page<ContactDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDto);
    }
    public ContactDTO toDto(Contact obj) {
        return new ContactDTO(obj.getId(), obj.getType().getDesc(), obj.getContact(),obj.isPreferential());
    }
}
