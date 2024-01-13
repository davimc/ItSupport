package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditableImpl implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime updatedAt;

    @OneToMany
    @JoinColumn(name = "updated_by")
    private List<User> updatedBy;

    /* TODO ver que porcaria é essa que tá criando a tabela auditable_impl_update
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<User> updatedBy;*/

    public AuditableImpl(Long id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

}
