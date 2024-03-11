package br.com.github.davimc.ItSupport.dto.taskPart;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartShortDTO;
import br.com.github.davimc.ItSupport.dto.task.TaskDTO;
import br.com.github.davimc.ItSupport.entities.TaskPart;

public record TaskPartShortDTO(PartShortDTO partDTO, Integer quantity, Double price){

    public TaskPartShortDTO(TaskPart obj) {
        this(new PartShortDTO(obj.getPart()), obj.getQuantity(), obj.getPrice());
    }
}
