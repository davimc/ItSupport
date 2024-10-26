package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartNewDTO;
import br.com.github.davimc.ItSupport.dto.part.PartUpdateDTO;
import br.com.github.davimc.ItSupport.services.PartService;
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
@RequestMapping("/parts")
public class PartController {

    @Autowired
    private PartService service;

    @GetMapping
    public ResponseEntity<Page<PartDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PartDTO> create(@RequestBody PartNewDTO newDto) {
        PartDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartDTO> update(@PathVariable UUID id, @Valid @RequestBody  PartUpdateDTO updateDTO) {
        return ResponseEntity.accepted().body(service.update(id, updateDTO));
    }
}
