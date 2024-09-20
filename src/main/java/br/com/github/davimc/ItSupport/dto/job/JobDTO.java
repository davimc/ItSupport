package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record JobDTO(UUID id, int os, String clientName, String status, String tech, String type, String tec, LocalDateTime createdAt, LocalDateTime finishedAt)
{
    public JobDTO(Job obj){
        this(obj.getId(), obj.getOs(),
                obj.getDevices().stream().findAny().get().getUser().getName(),
                obj.getStatus().getDesc(), obj.getTech().getName(),
                obj.getType().getDesc(), obj.getTech().getName(),
                obj.getCreatedAt(), obj.getFinishedAt());
    }
}
