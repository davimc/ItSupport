package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
public abstract class AuditableImpl implements Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public AuditableImpl() {
        createdAt = LocalDateTime.now();
    }
}
