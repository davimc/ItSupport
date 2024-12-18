package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public void setUpdateAt() {
        this.updatedAt = LocalDateTime.now();

    }

    public AuditableImpl(LocalDateTime createdAt) {
        this.createdAt = createdAt != null? createdAt : LocalDateTime.now();
    }
}
