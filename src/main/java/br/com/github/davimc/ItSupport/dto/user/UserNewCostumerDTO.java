package br.com.github.davimc.ItSupport.dto.user;

import br.com.github.davimc.ItSupport.entities.Address;
import br.com.github.davimc.ItSupport.entities.Role;
import br.com.github.davimc.ItSupport.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public record UserNewCostumerDTO(@NotNull(message = "Name cannot be null") String name, @NotNull(message = "Email cannot be null") @Email(message = "Invalid email format") String email,
                                 @NotNull(message = "Document cannot be null") String document,
                                 Integer type, String tel, String birthdate,
                                 @NotNull(message = "CEP cannot be null") String cep, String street, Integer number, String district, String city, @Size(min = 2,max = 2, message = "Just the acronym for the state") String state) {

    public User copyToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //todo lembrar de corrigir password
        return new User(name, email, "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG", "", LocalDate.parse(birthdate, formatter),document, null, null);
    }
}
