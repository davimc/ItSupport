package br.com.github.davimc.ItSupport.dto.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public record RegisterDTO(@NotNull(message = "Login is required") @Email(message = "Incorrect format")
                          String login,
                          @NotNull(message = "Password is required")
                          String password,
                          @NotNull(message = "Name is required")
                          String name,
                          @NotNull(message = "Address is required")
                          String address,
                          @NotNull(message = "CPF is required")
                          String cpf,
                          String obs,
                          @NotNull(message = "Perfil is required")
                          List<String> roles) {

}

