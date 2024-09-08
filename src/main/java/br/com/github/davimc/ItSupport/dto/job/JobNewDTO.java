package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.dto.jobDescription.JobDescriptionDTO;
import br.com.github.davimc.ItSupport.dto.jobDescription.JobDescriptionNewDTO;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.entities.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobNewDTO {

    @PastOrPresent(message = "Data de criação não pode ser no futuro")
    private LocalDateTime createdAt;

    @NotNull(message = "É necessário informar o cliente para criar um serviço")
    private UUID clientId;

    @NotNull(message = "É necessário indicar o técnico do serviço")
    private UUID techId;
    private List<JobDescriptionNewDTO> descriptions = new ArrayList<>();
    public Job copyToEntity(){
        return  new Job(null,0, StatusEnum.START, createdAt, null, null, null, null, null);
    }

}
