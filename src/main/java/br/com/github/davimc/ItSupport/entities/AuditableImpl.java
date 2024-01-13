package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditableImpl implements Auditable {
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "tb_users_updates",
    joinColumns = @JoinColumn(name = "update_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> updatedBy = new ArrayList<>();

    public AuditableImpl(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
