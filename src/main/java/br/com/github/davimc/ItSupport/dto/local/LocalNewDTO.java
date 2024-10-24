package br.com.github.davimc.ItSupport.dto.local;

import br.com.github.davimc.ItSupport.entities.Local;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocalNewDTO {

    @NotNull(message = "name is required")
    private String name;


    public Local copyToEntity(){
        return  new Local(null,name);
    }
}
