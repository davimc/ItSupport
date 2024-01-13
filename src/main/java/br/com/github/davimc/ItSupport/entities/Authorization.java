package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_authorizations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Authorization extends AuditableImpl{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime answeredAt;
    private Boolean isAccept;

    private String note;

    // TODO mudar de service para task
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public Authorization(UUID id, LocalDateTime createdAt, String note) {
        super(createdAt);
        this.id = id;
        this.note = note;
    }
}
