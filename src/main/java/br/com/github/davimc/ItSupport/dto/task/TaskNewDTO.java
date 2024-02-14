package br.com.github.davimc.ItSupport.dto.task;

import br.com.github.davimc.ItSupport.entities.Local;
import br.com.github.davimc.ItSupport.entities.Task;
import br.com.github.davimc.ItSupport.entities.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskNewDTO {

    private String description;
    private UUID jobId;
    private int type;
    private UUID deviceId;


    public Task copyToEntity(){
        return new Task(null, LocalDateTime.now(), null, null, TaskType.toEnum(type), null, null, null, description);
    }
}
