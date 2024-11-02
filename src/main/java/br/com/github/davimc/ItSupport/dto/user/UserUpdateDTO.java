package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
public class UserUpdateDTO {

    @Size(min = 2, max = 80, message = "Name must have a minimum of 2 characters and a maximum of 80")
    private String name;
    private String obs;
    @Past(message = "Birthdate canno't be current or future")
    private LocalDate birthdate;


    public User copyToEntity(User obj) {
        obj.setName(name != null ? name : obj.getName());
        obj.setObs(obs != null ? obs : obj.getObs());
        obj.setBirthdate(birthdate != null ? birthdate : obj.getBirthdate());

        return obj;
    }
}
