package br.com.github.davimc.ItSupport.controllers;

import br.com.github.davimc.ItSupport.dto.task.TaskDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskNewDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskWithTaskPartDTO;
import br.com.github.davimc.ItSupport.dto.taskPart.TaskPartNewDTO;
import br.com.github.davimc.ItSupport.entities.Task;
import br.com.github.davimc.ItSupport.services.TaskPartService;
import br.com.github.davimc.ItSupport.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private TaskPartService taskPartService;

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

/*
    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskNewDTO newDto) {
        TaskDTO dto = service.create(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }
*/

    /** TODO analisar como devo fazer essa inserção
    * criar um controller apenas para um único (create)
     * manter dessa forma e ver a melhor forma
     * obs: é um put ou post?
     *
     */
    /*@PostMapping ResponseEntity<TaskWithTaskPartDTO> addPart(@RequestBody TaskPartNewDTO dto) {
        taskPartService.create(dto);

        return ResponseEntity.accepted().body();
    }*/
}
