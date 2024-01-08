package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", length = 1, discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class User implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate createdAt;
    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDate updatedAt;

    //TODO testar como é a saída disso
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by")
    private List<User> updatedBy;
    @ToString.Exclude
    private String password;



}
