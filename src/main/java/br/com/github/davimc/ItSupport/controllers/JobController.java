package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.dto.job.JobNewDTO;
import br.com.github.davimc.ItSupport.dto.job.JobTotalDTO;
import br.com.github.davimc.ItSupport.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;
    //TODO não esquecer de adaptar isso
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<Page<JobTotalDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
// ToDo Resolve vulnerability issue in URI redirection
    // TODO Issue ele não está validando a lista de dispositivos(devicesId) quando vai vazia.
    @PostMapping
    public ResponseEntity<JobDTO> insert(@RequestBody @Valid JobNewDTO newDto) {
        JobDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .build(dto.id());

        return ResponseEntity.created(uri).body(dto);
    }
}
