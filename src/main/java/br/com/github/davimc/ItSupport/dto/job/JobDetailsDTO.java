package br.com.github.davimc.ItSupport.dto.job;

import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.entities.enums.JobStatus;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDetailsDTO {

    private UUID id;
    private JobStatus status;
    private JobType type;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private Set<UUID> devicesId;
    private UUID techId;

    //TODO verifica o motivo dele querer sempre passar como object
    public JobDetailsDTO(UUID id, JobStatus status, JobType type, LocalDateTime createdAt, LocalDateTime finishedAt, Object devicesId, UUID techId) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.devicesId = convertDevicesId(devicesId);
        this.techId = techId;
    }

    private Set<UUID> convertDevicesId(Object devicesId) {
        String devices = (String) devicesId;
        if (devices == null || devices.isEmpty()) {
            return Set.of(); //
        }

        // Divide a string pelo separador (por padrão, será uma vírgula)
        return Arrays.stream(devices.split(","))
                .map(UUID::fromString)
                .collect(Collectors.toSet());

    }
}
