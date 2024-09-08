package br.com.github.davimc.ItSupport.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();


}
