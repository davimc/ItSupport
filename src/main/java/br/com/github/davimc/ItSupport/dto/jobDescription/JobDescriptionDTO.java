package br.com.github.davimc.ItSupport.dto.jobDescription;

import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.JobDescription;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record JobDescriptionDTO(UUID id, DeviceShortDTO device, String description)
{
    public JobDescriptionDTO(JobDescription obj){
        this(obj.getId(), new DeviceShortDTO(obj.getDevice()), obj.getDescription());
    }


}
