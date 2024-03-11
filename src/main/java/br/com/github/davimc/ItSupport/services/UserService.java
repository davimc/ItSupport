package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.login.RegisterDTO;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.RoleRepository;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
import br.com.github.davimc.ItSupport.dto.contact.ContactDTO;
import br.com.github.davimc.ItSupport.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.dto.user.UserShortDTO;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;

    protected User find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, User.class));
    }

    public UserDTO findById(UUID id) {
        User obj = find(id);

        return new UserDTO(obj, obj.getContacts());
    }
    public Page<UserShortDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserShortDTO::new);
    }

    public UserDTO insert(RegisterDTO dto) {
        if(findByLogin(dto.login()).isPresent()) throw new IllegalArgumentException(dto.login() + "already registered");
        String passwordEncrypted = encoder.encode(dto.password());
        System.out.println(passwordEncrypted);
        System.out.println(dto.password());

        //TODO alterar quando criar person
        User user = new User(null, dto.name(), dto.address(), dto.login(), dto.cpf(), passwordEncrypted, LocalDateTime.now(), null, null,null, dto.obs(),null, null);
        user.getRoles().addAll(dto.roles().stream().map(roleRepository::findByAuthority).collect(Collectors.toSet()));
        user = repository.save(user);

        return new UserDTO(user, user.getContacts());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() -> new ObjectNotFoundException(username, User.class));
    }

    @Transactional(readOnly = true)
    public Optional<User> findByLogin (String username) {
        return repository.findByEmail(username);
    }
}
