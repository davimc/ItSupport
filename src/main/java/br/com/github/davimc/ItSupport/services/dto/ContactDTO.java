package br.com.github.davimc.ItSupport.services.dto;

import java.util.UUID;

public record ContactDTO(UUID id, String type, String contact, Boolean preferential) {
}
