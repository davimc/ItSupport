package br.com.github.davimc.ItSupport.dto.task;

import br.com.github.davimc.ItSupport.entities.Task;
import br.com.github.davimc.ItSupport.entities.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        return new Task(LocalDateTime.now(),TaskType.toEnum(type), null, null, null, "", 0.0);
    }
}
