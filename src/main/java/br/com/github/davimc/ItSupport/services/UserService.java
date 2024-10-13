package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.login.RegisterDTO;
import br.com.github.davimc.ItSupport.entities.Role;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.projections.UserDetailsProjection;
import br.com.github.davimc.ItSupport.repositories.RoleRepository;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
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

import java.time.LocalDate;
import java.util.List;
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

        return new UserDTO(obj);
    }
    public Page<UserShortDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserShortDTO::new);
    }

    public Page<UserDTO> findByAuthority(Pageable pageable,String authority) {
        return repository.findUsersByRoleAuthority(pageable,authority).map(UserDTO::new);
    }

    public UserDTO insert(RegisterDTO dto) {
        if(findByLogin(dto.login()).isPresent()) throw new IllegalArgumentException(dto.login() + "already registered");
        String passwordEncrypted = encoder.encode(dto.password());

        //TODO alterar quando criar person
        //TODO alterar address
        User user = new User(dto.name(), dto.login(), passwordEncrypted,dto.obs(), LocalDate.now(),null,null);
        user.getRoles().addAll(dto.roles().stream().map(roleRepository::findByAuthority).collect(Collectors.toSet()));
        user = repository.save(user);

        return new UserDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if(result.size() == 0) {
            throw new ObjectNotFoundException(username, User.class);
        }
        User obj = new User();
        obj.setEmail(username);
        obj.setPassword(result.get(0).getPassword());
        for(UserDetailsProjection projection: result) {
            obj.addRole(new Role(projection.getRoleId(),projection.getAuthority()));
        }

        return obj;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByLogin (String username) {
        return repository.findByEmail(username);
    }
}
