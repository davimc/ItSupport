package br.com.github.davimc.ItSupport.entities;

import java.time.LocalDate;
import java.util.List;

public interface Auditable {
    LocalDate getCreatedAt();
    void setCreatedAt(LocalDate obj);
    LocalDate getUpdatedAt();
    void setUpdatedAt(LocalDate obj);
    User getCreatedBy();
    void setCreatedBy(User user);

}
