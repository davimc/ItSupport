package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobStatus;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobUpdateDTO {

    private LocalDateTime finishedAt;

    private List<UUID> devicesId = new ArrayList<>();

    private UUID techId;

    private int jobType;

    private int jobStatus;



    public Job copyToEntity(Job job){
        //TODO
        job.setFinishedAt(getFinishedAt());
        job.setStatus(JobStatus.toEnum(getJobStatus()));
        job.setType(JobType.toEnum(getJobType()));

        throw new UnsupportedOperationException("Not yet implemented");
    }

}
