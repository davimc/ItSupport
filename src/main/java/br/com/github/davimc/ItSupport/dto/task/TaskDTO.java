package br.com.github.davimc.ItSupport.dto.task;

import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.entities.Local;
import br.com.github.davimc.ItSupport.entities.Task;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(UUID id, LocalDateTime createdAt, LocalDateTime finishedAt, String type, JobDTO job, DeviceShortDTO device, String description){
    public TaskDTO(Task obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getFinishedAt(), obj.getType().getDesc(), new JobDTO(obj.getJob()), new DeviceShortDTO(obj.getDevice()), obj.getDescription());
    }
}
