package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum ContactType {
    EMAIL(1, "email"), FIXO(2, "telefone fixo"),
    CELULAR(3,"celular");

    private final int cod;
    private final String desc;

    ContactType(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }
}
