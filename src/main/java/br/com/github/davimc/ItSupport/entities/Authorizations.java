package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_authorizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime answeredAt;
    private Boolean isAccept;
}
