package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.ContactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.ORDINAL)
    private ContactType type;
    private String contact;

    private boolean preferential;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
