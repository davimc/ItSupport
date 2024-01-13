package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.dto.user.UserNewDTO;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    protected User find(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException(id, User.class));
    }

    public UserDTO findById(Long id) {
        return new UserDTO(find(id));
    }

    public Page<UserDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserDTO::new);
    }

    // TODO fazer o security
}
