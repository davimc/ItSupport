package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.task.TaskDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskWithTaskPartDTO;
import br.com.github.davimc.ItSupport.dto.taskPart.TaskPartDTO;
import br.com.github.davimc.ItSupport.dto.taskPart.TaskPartNewDTO;
import br.com.github.davimc.ItSupport.entities.*;
import br.com.github.davimc.ItSupport.repositories.TaskPartRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskPartService {
    @Autowired
    private TaskPartRepository repository;

    @Autowired
    private PartService partService;
    @Autowired
    private TaskService taskService;



    protected TaskPart find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Task.class));
    }

    public TaskPartDTO create(TaskPartNewDTO dto) {
        TaskPart obj = dto.copyToEntity();
        obj.setTask(taskService.find(dto.getTaskId()));
        obj.setPart(partService.find(dto.getPartId()));

        obj = repository.save(obj);

        return new TaskPartDTO(obj);
    }
}
