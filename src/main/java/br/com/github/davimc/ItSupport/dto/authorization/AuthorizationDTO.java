package br.com.github.davimc.ItSupport.dto.authorization;

import br.com.github.davimc.ItSupport.entities.Authorization;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AuthorizationDTO {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime answeredAt;
    private Boolean isAccept;

    public AuthorizationDTO() {
    }

    public AuthorizationDTO(Long id, LocalDateTime createdAt, LocalDateTime answeredAt, Boolean isAccept) {
        this.id = id;
        this.createdAt = createdAt;
        this.answeredAt = answeredAt;
        this.isAccept = isAccept;
    }
    public AuthorizationDTO(Authorization obj) {
        id = obj.getId();
        createdAt = obj.getCreatedAt();
        answeredAt = obj.getAnsweredAt();
        isAccept = obj.getIsAccept();
    }


}
