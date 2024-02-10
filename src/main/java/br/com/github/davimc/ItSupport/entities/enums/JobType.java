package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum JobType {
    COMMON(1, "Serviço Comum"), GUARANTEE(2, "Garantia"),
    RETURN(3,"Retorno"), OTHERS(4, "Outros");

    private final Integer cod;
    private final String desc;

    JobType(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static JobType toEnum(Integer cod){
        if(cod == null) return null;
        for(JobType x: JobType.values())
            if(cod.equals(x.getCod()))
                return x;
        throw new IllegalArgumentException("Tipo inválido");
    }

}
