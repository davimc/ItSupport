package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum DeviceType {
    PRINTER(1, "Impressora"), PC(2, "PC"),
    CELPHONE(3,"Smartphone"), OTHERS(4, "Outros");

    private final int cod;
    private final String desc;

    DeviceType(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }
}
