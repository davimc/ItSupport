package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditableImpl implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalDate createdAt;
    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDate updatedAt;

    @OneToMany
    @JoinColumn(name = "updated_by")
    private List<User> updatedBy;

    /* TODO ver que porcaria é essa que tá criando a tabela auditable_impl_update
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<User> updatedBy;*/

    public AuditableImpl(Long id, LocalDate createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuditableImpl auditable = (AuditableImpl) o;
        return getId() != null && Objects.equals(getId(), auditable.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
