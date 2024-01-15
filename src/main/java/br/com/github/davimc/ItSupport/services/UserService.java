package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
import br.com.github.davimc.ItSupport.services.dto.contact.ContactDTO;
import br.com.github.davimc.ItSupport.services.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.services.dto.user.UserShortDTO;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    protected User find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, User.class));
    }

    public UserDTO findById(UUID id) {
        User obj = find(id);

        return new UserDTO(obj, obj.getContacts().stream().map(ContactDTO::new).toList());
    }
    public Page<UserShortDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserShortDTO::new);
    }
}
