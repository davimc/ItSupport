package br.com.github.davimc.ItSupport.dto.taskPart;

import br.com.github.davimc.ItSupport.entities.TaskPart;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TaskPartNewDTO {
    private UUID taskId;
    private UUID partId;
    private Integer quantity;
    private Double price;
    public TaskPart copyToEntity(){
        return new TaskPart(null, quantity, price, null, null);
    }
}
