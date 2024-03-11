package br.com.github.davimc.ItSupport.dto.task;

import br.com.github.davimc.ItSupport.dto.taskPart.TaskPartShortDTO;
import br.com.github.davimc.ItSupport.entities.Task;

import java.util.List;

public record TaskWithTaskPartDTO(TaskDTO taskDTO, List<TaskPartShortDTO> taskPartDTO){
    public TaskWithTaskPartDTO(Task obj){
        this(new TaskDTO((obj)), obj.getTaskParts().stream().map(TaskPartShortDTO::new).toList());
    }
}