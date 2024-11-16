package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.DeviceType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_devices")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Device extends AuditableImpl {
    @Enumerated(EnumType.ORDINAL)
    @NonNull
    private DeviceType type;
    @NonNull
    private String brand;
    private String serial;
    @NonNull
    private String model;
    @NonNull
    private String characteristics;
    @NonNull
    private String obs;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany(mappedBy = "devices")
    private List<Job> jobs = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return getId().equals(device.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
