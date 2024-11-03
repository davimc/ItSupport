package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.login.RegisterDTO;
import br.com.github.davimc.ItSupport.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.dto.user.UserShortDTO;
import br.com.github.davimc.ItSupport.dto.user.UserUpdateDTO;
import br.com.github.davimc.ItSupport.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Page<UserShortDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/costumers")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Page<UserShortDTO>> findCostumers(Pageable pageable) {
        return ResponseEntity.ok().body(service.findByAuthorityCostumer(pageable));
    }

    @PostMapping("/costumers/create")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<UserDTO> createCostumer(@RequestBody @Valid RegisterDTO registerDTO) {
        UserDTO dto = service.insert(registerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .build(dto.id());

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/technicians")
    public ResponseEntity<Page<UserShortDTO>> findTech(Pageable pageable) {
        return ResponseEntity.ok().body(service.findByAuthorityTechnician(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserShortDTO> update(@PathVariable UUID id, @RequestBody @Valid UserUpdateDTO dto) {
        return ResponseEntity.accepted().body(service.update(id, dto));
    }
}
