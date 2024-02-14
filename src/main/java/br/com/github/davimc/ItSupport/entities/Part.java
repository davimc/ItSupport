
package br.com.github.davimc.ItSupport.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_parts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double price;
    private Double percentageSale;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @OneToMany(mappedBy = "part")
    private Set<TaskPart> taskParts = new HashSet<>();
}
