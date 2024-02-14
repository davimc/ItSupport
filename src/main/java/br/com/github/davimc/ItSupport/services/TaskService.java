package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.task.TaskDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskNewDTO;
import br.com.github.davimc.ItSupport.entities.Task;
import br.com.github.davimc.ItSupport.repositories.TaskRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private JobService jobService;

    protected Task find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Task.class));
    }

    public TaskDTO findById(UUID id) {
        Task obj = find(id);

        return new TaskDTO(obj);
    }
    public Page<TaskDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(TaskDTO::new);
    }

    public TaskDTO create(TaskNewDTO dto){
        Task obj = dto.copyToEntity();
        obj.setDevice(deviceService.find(dto.getDeviceId()));
        obj.setJob(jobService.find(dto.getJobId()));

        obj = repository.save(obj);

        return new TaskDTO(obj);
    }
}
