package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.user.UserDTO;
import br.com.github.davimc.ItSupport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAllPage(@PageableDefault(sort = "name") Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    /*@PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserNewDTO newDto) {
        UserDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }*/
}
