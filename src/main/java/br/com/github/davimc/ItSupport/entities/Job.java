package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.entities.enums.JobStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_jobs")
@Getter
@Setter
@NoArgsConstructor
public class Job extends AuditableImpl {

    private Integer os;
    @Enumerated(EnumType.ORDINAL)
    private JobStatus status;
    @Enumerated(EnumType.ORDINAL)
    private JobType type;
    private LocalDateTime finishedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_jobs_devices",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private Set<Device> devices = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User tech;

    @OneToMany(mappedBy = "job")
    private List<Task> tasks = new ArrayList<>();

    public Job(Integer os, JobType type, LocalDateTime started, User tech, Set<Device> device) {
        super(started);
        this.os = os;
        this.status = JobStatus.STARTED;
        this.type = type;
        this.tech = tech;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
