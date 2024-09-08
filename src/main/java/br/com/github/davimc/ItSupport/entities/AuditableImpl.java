package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
public class AuditableImpl implements Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    public AuditableImpl() {
        createdAt = LocalDate.now();
    }
}
