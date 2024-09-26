package br.com.github.davimc.ItSupport.dto.projections;

import java.time.LocalDateTime;
import java.util.UUID;

public interface JobView {

    UUID getId();
    int getOs();
    String getClientName();
    int getStatus();
    int getType();
    String getTechName();
    LocalDateTime getCreatedAt();
    LocalDateTime getFinishedAt();
    Double getTotal();
}
