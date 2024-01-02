package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartNewDTO;
import br.com.github.davimc.ItSupport.services.PartService;
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
@RequestMapping("/parts")
public class PartController {

    @Autowired
    private PartService service;

    @GetMapping("/{id}")
    public ResponseEntity<PartDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<Page<PartDTO>> findAllPage(@PageableDefault(sort = "name") Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<PartDTO> create(@RequestBody @Valid PartNewDTO newDto) {
        PartDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
