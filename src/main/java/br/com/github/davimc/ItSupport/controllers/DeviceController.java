package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.device.DeviceDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceNewDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceUpdateDTO;
import br.com.github.davimc.ItSupport.services.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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

    @GetMapping("/owner/{ownerId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<DeviceShortDTO>> findByOwner(@PathVariable UUID ownerId) {
        return ResponseEntity.ok().body(service.findByOwner(ownerId));
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody DeviceNewDTO newDto) {
        DeviceDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDTO> update(@PathVariable UUID id, @RequestBody @Valid DeviceUpdateDTO dto) {
        return ResponseEntity.accepted().body(service.update(id, dto));
    }
}
