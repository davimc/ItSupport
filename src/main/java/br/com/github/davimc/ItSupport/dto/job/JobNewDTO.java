package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobNewDTO {

    private String description;

    @NotNull(message = "list of devices is required")
    private List<UUID> devicesId;

    @NotNull(message = "type is required")
    private int type;
    public Job copyToEntity(){
        return  new Job(null, LocalDateTime.now(), null, null, JobType.toEnum(type), null, description);
    }
}
