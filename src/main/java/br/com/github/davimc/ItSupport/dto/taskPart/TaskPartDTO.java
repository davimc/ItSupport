package br.com.github.davimc.ItSupport.dto.taskPart;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskDTO;
import br.com.github.davimc.ItSupport.entities.TaskPart;

public record TaskPartDTO(TaskDTO taskDTO, PartDTO partDTO, Integer quantity, Double price){

    public TaskPartDTO(TaskPart obj) {
        this(new TaskDTO(obj.getTask()), new PartDTO(obj.getPart()), obj.getQuantity(), obj.getPrice());
    }
}
