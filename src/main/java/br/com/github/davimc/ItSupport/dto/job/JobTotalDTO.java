package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.entities.enums.JobStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record JobTotalDTO(UUID id, Integer os, String status, LocalDateTime createdAt, String type, LocalDateTime finishedAt, String clientName, String techName, Double total)
{
    public JobTotalDTO(UUID id, Integer os, JobStatus status, LocalDateTime createdAt, JobType type, LocalDateTime finishedAt, String clientName, String techName, Double total){
        this(id, os, status.getDesc(), createdAt, type.getDesc(), finishedAt, clientName, techName, total);
    }
}
