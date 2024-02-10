package br.com.github.davimc.ItSupport.dto.device;

import br.com.github.davimc.ItSupport.entities.Device;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeviceShortDTO(UUID id,  String type, String brand, String model, String characteristics, String obs)
{
    public DeviceShortDTO(Device obj){
        this(obj.getId(), obj.getType().getDesc(),obj.getBrand(), obj.getModel(), obj.getCharacteristics(), obj.getObs());
    }
}
