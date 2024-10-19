package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobNewDTO {

    @PastOrPresent(message = "Data de criação não pode ser no futuro")
    private LocalDateTime createdAt;

    @NotBlank(message = "É necessário informar ao menos um dispositivo para criar o serviço")
    private List<UUID> devicesId = new ArrayList<>();

    @NotNull(message = "É necessário indicar o técnico do serviço")
    private UUID techId;

    @NotNull(message = "É necessário informar um tipo de serviço")
    private int jobType;


    public Job copyToEntity(){
        //TODO como pegar a nova OS para o novo serviço sem precisar acessar o BD?
        return  new Job(1, JobType.toEnum(jobType), createdAt, null, null);
    }

}
