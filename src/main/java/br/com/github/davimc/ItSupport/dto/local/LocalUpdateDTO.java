package br.com.github.davimc.ItSupport.dto.local;

import br.com.github.davimc.ItSupport.entities.Local;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class LocalUpdateDTO {
    @NotNull(message = "Local name cannot be null")
    private String name;


    public Local fromEntity(Local obj) {
        obj.setName(getName() != null ? getName() : obj.getName());

        return obj;
    }
}
