package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.authorization.AuthorizationDTO;
import br.com.github.davimc.ItSupport.dto.authorization.AuthorizationNewDTO;
import br.com.github.davimc.ItSupport.services.AuthorizationService;
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
@RequestMapping("/authorizations")
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorizationDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<Page<AuthorizationDTO>> findAllPage(@PageableDefault(sort = "createdAt") Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<AuthorizationDTO> create(@RequestBody @Valid AuthorizationNewDTO newDto) {
        AuthorizationDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
