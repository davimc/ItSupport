package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum DeviceType {
    PRINTER(1, "Impressora"), PC(2, "PC"),
    CELPHONE(3,"Smartphone"), OTHERS(4, "Outros");

    private final Integer cod;
    private final String desc;

    DeviceType(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static DeviceType toEnum(Integer cod){
        if(cod == null) return null;
        for(DeviceType x: DeviceType.values())
            if(cod.equals(x.getCod()))
                return x;
        throw new IllegalArgumentException("Tipo inválido");
    }

}
