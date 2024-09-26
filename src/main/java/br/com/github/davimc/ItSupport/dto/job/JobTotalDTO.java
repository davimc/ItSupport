package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.dto.projections.JobView;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.entities.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record JobTotalDTO(UUID id, int os, String clientName, String status, String type, String techName, LocalDateTime createdAt, LocalDateTime finishedAt, Double total)
{
    public JobTotalDTO(JobView obj){
        this(obj.getId(), obj.getOs(),
                obj.getClientName(),
                StatusEnum.toEnum(obj.getStatus()).getDesc(),
                JobType.toEnum(obj.getType()).getDesc(), obj.getTechName(),
                obj.getCreatedAt(), obj.getFinishedAt(), obj.getTotal());
    }
}
