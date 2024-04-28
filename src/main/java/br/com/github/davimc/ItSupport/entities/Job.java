package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime finishedAt;

    @OneToMany(mappedBy = "job")
    private Set<JobDescription> descriptions = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User tech;
}
