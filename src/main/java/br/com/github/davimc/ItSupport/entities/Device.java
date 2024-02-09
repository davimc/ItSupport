package br.com.github.davimc.ItSupport.entities;

import br.com.github.davimc.ItSupport.entities.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.ORDINAL)
    private DeviceType type;
    private String brand;
    private String model;
    private String characteristics;
    private String obs;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;
}
