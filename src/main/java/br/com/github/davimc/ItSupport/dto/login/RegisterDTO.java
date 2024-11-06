package br.com.github.davimc.ItSupport.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.List;

public record RegisterDTO(@NotNull(message = "Login is required") @Email(message = "Incorrect format")
                          String login,
                          @NotNull(message = "Password is required")
                          String password,
                          @NotNull(message = "Name is required")
                          String name,
                          @NotNull(message = "Document cannot be null")
                                  @Size(min = 11, max = 19, message = "Document range is between 11-19 characteres")
                          String document,
                          @NotNull(message = "CEP cannot be null") String cep,
                          String street,
                          Integer number,
                          String district,
                          String city,
                          String complement,
                          String reference,
                          @Size(min = 2,max = 2, message = "Just the acronym for the state")
                          String state,
                          String branch,
                          @NotNull(message = "Document is required")
                          @Size(min = 11, max = 14, message = "Quantity of data does not match")
                          String Document,
                          String obs,
                          @NotNull(message = "Perfil is required")
                          List<String> roles) {

}

