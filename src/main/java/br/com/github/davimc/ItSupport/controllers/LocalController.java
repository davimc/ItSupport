package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.local.LocalDTO;
import br.com.github.davimc.ItSupport.dto.local.LocalNewDTO;
import br.com.github.davimc.ItSupport.dto.local.LocalUpdateDTO;
import br.com.github.davimc.ItSupport.services.LocalService;
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
@RequestMapping("/locals")
public class LocalController {

    @Autowired
    private LocalService service;

    @GetMapping
    public ResponseEntity<Page<LocalDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocalDTO> create(@RequestBody @Valid LocalNewDTO newDto) {
        LocalDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalDTO> update(@PathVariable UUID id, @RequestBody @Valid LocalUpdateDTO dto) {
        return ResponseEntity.accepted().body(service.udpate(id, dto));
    }
}
