package br.com.github.davimc.ItSupport.dto.part;

import br.com.github.davimc.ItSupport.entities.Part;

import java.util.UUID;

public record PartShortDTO(UUID id, String name, double priceSuggested) {
    public PartShortDTO(Part obj){
        this(obj.getId(), obj.getName(),obj.getPrice());
    }
}
