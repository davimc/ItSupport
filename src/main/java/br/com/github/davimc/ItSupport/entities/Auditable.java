package br.com.github.davimc.ItSupport.entities;

import java.time.LocalDate;

public interface Auditable {
    LocalDate getCreatedAt();
    LocalDate getUpdatedAt();


}
