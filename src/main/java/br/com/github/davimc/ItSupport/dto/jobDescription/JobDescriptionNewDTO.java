package br.com.github.davimc.ItSupport.dto.jobDescription;

import br.com.github.davimc.ItSupport.dto.device.DeviceShortDTO;
import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.entities.JobDescription;

import java.util.UUID;

public record JobDescriptionNewDTO(UUID device, String description, int type)
{


}
