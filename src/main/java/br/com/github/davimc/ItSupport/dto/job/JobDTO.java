package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.entities.Job;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record JobDTO(UUID id, LocalDateTime createdAt, LocalDateTime finishedAt, String type, String description, List<DeviceShortDTO> divices)
{
    public JobDTO(Job obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getFinishedAt(), obj.getType().getDesc(), obj.getDescription(), obj.getDevices().stream().map(DeviceShortDTO::new).toList());
    }
}
