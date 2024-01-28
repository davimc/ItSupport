package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    // TODO tb_addresses
    private String endereco;

    //TODO cpf e cnpj
    @Column(unique = true)
    private String cpf;
    private String password;

    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    private String obs;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Contact> contacts = new ArrayList<>();


}
