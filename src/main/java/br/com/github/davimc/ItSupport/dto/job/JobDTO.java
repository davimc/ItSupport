package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record JobDTO(UUID id, LocalDateTime createdAt, LocalDateTime finishedAt)
{
    public JobDTO(Job obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getFinishedAt());
    }
}
