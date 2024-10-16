package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.User;

import java.time.LocalDate;
import java.util.UUID;

public record UserCostumerDTO(UUID id, String name/*, String document*/, String email, String obs, LocalDate birthdate) {
    public UserCostumerDTO(User obj) {
        this(obj.getId(), obj.getName(), /*obj.getDocument*/ obj.getEmail(), obj.getObs(), obj.getBirthdate());
    }
}
