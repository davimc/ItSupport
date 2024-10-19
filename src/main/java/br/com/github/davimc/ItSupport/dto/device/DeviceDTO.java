package br.com.github.davimc.ItSupport.dto.device;

import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.Local;
import br.com.github.davimc.ItSupport.entities.enums.DeviceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeviceDTO(UUID id, LocalDateTime createdAt,String type, String brand,String model, String characteristics,String obs, String clientName)
{
    public DeviceDTO(Device obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getType().getDesc(),obj.getBrand(), obj.getModel(), obj.getCharacteristics(), obj.getObs(), obj.getUser().getName());
    }
}
