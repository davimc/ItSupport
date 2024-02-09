package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.device.DeviceDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceNewDTO;
import br.com.github.davimc.ItSupport.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @GetMapping
    public ResponseEntity<Page<DeviceDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody DeviceNewDTO newDto) {
        DeviceDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }
}
