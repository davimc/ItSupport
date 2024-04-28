package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.dto.jobDescription.JobDescriptionDTO;
import br.com.github.davimc.ItSupport.entities.Job;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record JobDTO(UUID id, LocalDateTime createdAt, LocalDateTime finishedAt, List<JobDescriptionDTO> descriptions)
{
    public JobDTO(Job obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getFinishedAt(), obj.getDescriptions().stream().map(JobDescriptionDTO::new).toList());
    }
}
