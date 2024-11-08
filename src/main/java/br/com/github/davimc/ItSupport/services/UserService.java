package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.login.RegisterDTO;
import br.com.github.davimc.ItSupport.dto.user.UserUpdateDTO;
import br.com.github.davimc.ItSupport.entities.Address;
import br.com.github.davimc.ItSupport.entities.Role;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.projections.UserDetailsProjection;
import br.com.github.davimc.ItSupport.repositories.AddressRepository;
import br.com.github.davimc.ItSupport.repositories.RoleRepository;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
import br.com.github.davimc.ItSupport.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.dto.user.UserTypifiedDTO;
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

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AddressRepository addressRepository;

    protected User find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, User.class));
    }

    protected User findTech(UUID id) {
        User tech = find(id);
        if (tech.getRoles().stream().anyMatch(u -> u.getAuthority().equals("ROLE_TECHNICIAN")))
            return tech;
        throw new IllegalArgumentException("Este usuário não possui acesso de técnico");
    }

    public UserDTO findById(UUID id) {
        User obj = find(id);

        return new UserDTO(obj);
    }

    public Page<UserTypifiedDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserTypifiedDTO::new);
    }

    private Page<User> findByAuthority(Pageable pageable, List<String> authority) {
        return repository.findUsersByRoleAuthority(pageable, authority);
    }

    public Page<UserDTO> findByAuthorityCostumer(Pageable pageable) {
        return findByAuthority(pageable, List.of("ROLE_COSTUMER")).map(UserDTO::new);
    }
    public Page<UserTypifiedDTO> findByAuthorityTechnician(Pageable pageable) {
        return findByAuthority(pageable, List.of("ROLE_TECHNICIAN")).map(UserTypifiedDTO::new);
    }
    //Only id, document and name
    public Page<UserTypifiedDTO> findByTechAndCostumer(Pageable pageable) {
        return findByAuthority(pageable, List.of("ROLE_COSTUMER","ROLE_TECHNICIAN")).map(UserTypifiedDTO::new);
    }



    public UserDTO insert(RegisterDTO dto) {
        if (findByLogin(dto.login()).isPresent())
            throw new IllegalArgumentException(dto.login() + "already registered");
        String passwordEncrypted = encoder.encode(dto.password());

        User obj = new User(dto.name(), dto.login(), passwordEncrypted, dto.obs(), LocalDate.now(), dto.document(), null, null);
        //TODO java.lang.NullPointerException: Cannot invoke "java.util.Set.addAll(java.util.Collection)" because the return value of "br.com.github.davimc.ItSupport.entities.User.getRoles()" is null
        //Set<Role> roles = dto.roles().stream().map(roleRepository::findByAuthority).collect(Collectors.toSet());

        obj = repository.save(obj);
        addressRepository.save(new Address(null, dto.street(), dto.district(), dto.number(), dto.complement(), dto.reference(), dto.cep(), dto.city(), dto.state(), dto.branch(), obj));

        return new UserDTO(obj);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new ObjectNotFoundException(username, User.class);
        }
        User obj = new User();
        obj.setEmail(username);
        obj.setPassword(result.getFirst().getPassword());
        for (UserDetailsProjection projection : result) {
            obj.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return obj;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByLogin(String username) {
        return repository.findByEmail(username);
    }


    @Transactional
    public UserTypifiedDTO update(UUID id, UserUpdateDTO dto) {
        User obj = find(id);
        obj = dto.copyToEntity(obj);

        obj = repository.save(obj);

        return new UserTypifiedDTO(obj);
    }


}
