package br.com.github.davimc.ItSupport.dto.local;

import br.com.github.davimc.ItSupport.entities.Local;

import java.util.UUID;

public record LocalDTO(UUID id, String name){
    public LocalDTO(Local obj){
        this(obj.getId(),obj.getName());
    }
}
