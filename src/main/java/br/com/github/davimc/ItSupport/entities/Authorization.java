package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_authorizations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Authorization extends AuditableImpl{
    private LocalDateTime answeredAt;
    private Boolean isAccept;

    private String note;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public Authorization(Long id, LocalDate createdAt, String note) {
        super(id, createdAt);
        this.note = note;
    }
}
