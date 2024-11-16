package br.com.github.davimc.ItSupport.dto.device;

import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.enums.DeviceType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class DeviceUpdateDTO {


    private Integer type;
    @NotBlank(message = "Brand cannot be empty")
    private String brand;
    @NotBlank(message = "Model cannot be empty")
    private String model;
    private String serial;

    private String characteristics;

    private String obs;

    private UUID owner;


    public Device fromEntity(Device obj) {
        obj.setType(type != null ? DeviceType.toEnum(getType()) : obj.getType());
        obj.setBrand(brand != null ? getBrand() : obj.getBrand());
        obj.setModel(model != null ? getModel() : obj.getBrand());
        obj.setSerial(serial != null ? getSerial() : obj.getSerial());
        obj.setCharacteristics(characteristics != null ? getCharacteristics() : obj.getCharacteristics());
        obj.setObs(obs != null? getObs() : obj.getObs());

        return obj;
    }
}
