package br.com.github.davimc.ItSupport.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface Auditable {
    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime obj);
    LocalDateTime getUpdatedAt();
    void setUpdatedAt(LocalDateTime obj);
    User getCreatedBy();
    void setCreatedBy(User user);

}
