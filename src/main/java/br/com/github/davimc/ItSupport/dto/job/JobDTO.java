package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;

import java.time.LocalDateTime;
import java.util.UUID;

public record JobDTO(UUID id, int os, String clientName, String status, String type, String tech, LocalDateTime createdAt, LocalDateTime finishedAt)
{
    public JobDTO(Job obj){
        this(obj.getId(), obj.getOs(),
                obj.getDevices().stream().findFirst().get().getOwner().getName(),
                obj.getStatus().getDesc(),
                obj.getType().getDesc(), obj.getTech().getName(),
                obj.getCreatedAt(), obj.getFinishedAt());
    }
}
