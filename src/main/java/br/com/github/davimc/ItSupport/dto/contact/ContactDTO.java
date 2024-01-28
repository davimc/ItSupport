package br.com.github.davimc.ItSupport.dto.contact;

import br.com.github.davimc.ItSupport.entities.Contact;

import java.util.UUID;

public record ContactDTO(UUID id, String type, String contact, Boolean preferential) {
    public ContactDTO (Contact obj){
        this(obj.getId(), obj.getType().getDesc(), obj.getContact(), obj.isPreferential());
    }
}
