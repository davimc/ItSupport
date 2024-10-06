package br.com.github.davimc.ItSupport.entities.enums;

import lombok.Getter;

@Getter
public enum JobStatus {
    STARTED(1, "Iniciado"), WAITING(2, "Aguardando"),
    APPROVED(3, "Aprovado"),ENDED(4, "Finalizado");

    private final int cod;
    private final String desc;

    JobStatus(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public static JobStatus toEnum(Integer cod){
        if(cod == null) return null;
        for(JobStatus x: JobStatus.values())
            if(cod.equals(x.getCod()))
                return x;
        throw new IllegalArgumentException("Tipo inválido");
    }

    @Override
    public String toString() {
        return "JobStatus{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
