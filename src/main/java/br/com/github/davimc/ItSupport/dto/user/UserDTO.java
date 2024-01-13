package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private String endereco;
    private String type;
    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.createdAt = obj.getCreatedAt();
        this.endereco = obj.getEndereco();
        type = obj.getDiscriminatorValue();
    }
}
