package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.entities.enums.StatusEnum;
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
public class Job extends AuditableImpl{

    private Integer os;
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;
    @Enumerated(EnumType.ORDINAL)
    private JobType type;
    private LocalDateTime finishedAt;

    @ManyToMany
    @JoinTable(name = "tb_jobs_devices",
            joinColumns = @JoinColumn(name= "job_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private Set<Device> devices = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User tech;

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
