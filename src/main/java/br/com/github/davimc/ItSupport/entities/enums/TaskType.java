package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum TaskType {
    PREVENTION(1, "Prevenção"), CORRECTION(2, "Correção"),
    OPTIONAL(3,"Opcional"), OTHERS(4, "Outros");

    private final Integer cod;
    private final String desc;

    TaskType(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static TaskType toEnum(Integer cod){
        if(cod == null) return null;
        for(TaskType x: TaskType.values())
            if(cod.equals(x.getCod()))
                return x;
        throw new IllegalArgumentException("Tipo inválido");
    }

}
