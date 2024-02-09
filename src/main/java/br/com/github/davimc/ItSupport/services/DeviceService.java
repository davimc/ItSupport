package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.device.DeviceDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceNewDTO;
import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.repositories.DeviceRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    protected Device find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Device.class));
    }

    public DeviceDTO findById(UUID id) {
        Device obj = find(id);

        return new DeviceDTO(obj);
    }
    public Page<DeviceDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(DeviceDTO::new);
    }

    public DeviceDTO create(DeviceNewDTO newDTO){
        Device obj = newDTO.copyToEntity();
        obj = repository.save(obj);

        return new DeviceDTO(obj);
    }
}
