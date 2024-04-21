package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    @Enumerated(EnumType.ORDINAL)
    private JobType type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_jobs_devices",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private Set<Device> devices = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User tech;
    private String description;
}
