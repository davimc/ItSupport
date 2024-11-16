package br.com.github.davimc.ItSupport.dto.device;

import br.com.github.davimc.ItSupport.entities.Device;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeviceDTO(UUID id, LocalDateTime createdAt,String type, String brand,String model, String serial, String characteristics,String obs, String ownerName)
{
    public DeviceDTO(Device obj){
        this(obj.getId(),obj.getCreatedAt(), obj.getType().getDesc(),obj.getBrand(), obj.getModel(), obj.getSerial(), obj.getCharacteristics(), obj.getObs(), obj.getOwner().getName());
    }
}
