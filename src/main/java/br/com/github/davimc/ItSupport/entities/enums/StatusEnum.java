package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    START(1, "Iniciado"), WAIT(2, "Aguardando"),
    APPROVAL(3, "Aprovado"),END(4, "Finalizado");

    private final int cod;
    private final String desc;

    StatusEnum(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static StatusEnum toEnum(Integer cod){
        if(cod == null) return null;
        for(StatusEnum x: StatusEnum.values())
            if(cod.equals(x.getCod()))
                return x;
        throw new IllegalArgumentException("Tipo inválido");
    }
}
