package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.job.*;
import br.com.github.davimc.ItSupport.repositories.JobRepository;
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

    @Autowired
    JobRepository repository;
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
    // TODO Issue validation não está funcionando, até o techId retorna um erro, no entanto não é o erro que deveria
    @PostMapping
    public ResponseEntity<JobDTO> insert(@RequestBody @Valid JobNewDTO newDto) {
        JobDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .build(dto.id());

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> update(@PathVariable UUID id, @RequestBody @Valid JobUpdateDTO updateDTO) {
        return ResponseEntity.accepted().body(service.update(id, updateDTO));
    }

    @GetMapping("/teste")
    public ResponseEntity<JobDetailsDTO> teste() {
        return ResponseEntity.ok().body(repository.findJobDetails(UUID.fromString("534eb9d6-3ad6-4602-b10a-5310471e16b4")).get());
    }
}
