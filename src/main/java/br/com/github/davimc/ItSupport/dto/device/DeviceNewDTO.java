package br.com.github.davimc.ItSupport.dto.device;

import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.entities.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceNewDTO {

    @NotNull(message = "brand is required")
    private String brand;
    @NotNull(message = "model is required")
    private String model;
    private String characteristics;
    private String obs;
    private UUID ownerId;

    @NotNull(message = "type is required")
    private int type;
    public Device copyToEntity(){
        return  new Device( DeviceType.toEnum(type), brand, model, characteristics, obs, new User());
    }
}
