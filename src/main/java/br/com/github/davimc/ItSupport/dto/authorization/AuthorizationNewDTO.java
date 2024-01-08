package br.com.github.davimc.ItSupport.dto.authorization;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.entities.Authorization;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AuthorizationNewDTO {
    private String note;

    public Authorization copyToEntity() {
        return new Authorization(null, LocalDate.now(), note);
    }
}
