package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.device.DeviceDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceNewDTO;
import br.com.github.davimc.ItSupport.dto.device.DeviceUpdateDTO;
import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.DeviceRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    @Autowired
    private UserService userService;

    protected Device find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Device.class));
    }

    public DeviceDTO findById(UUID id) {
        Device obj = find(id);

        return new DeviceDTO(obj);
    }

    protected Set<Device> findAll(List<UUID> devicesId) {
        return devicesId.stream().map(this::find).collect(Collectors.toSet());
    }

    public Page<DeviceDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(DeviceDTO::new);
    }

    public DeviceDTO create(DeviceNewDTO dto) {
        Device obj = dto.copyToEntity();
        User u = userService.find(dto.getOwnerId());
        obj.setUser(u);
        obj = repository.save(obj);

        return new DeviceDTO(obj);
    }

    public DeviceDTO update(UUID id, DeviceUpdateDTO dto) {
        Device obj = find(id);
        obj = dto.fromEntity(obj);
        if(dto.getUser() != null) obj.setUser(userService.find(dto.getUser()));

        obj.setUpdateAt();
        obj = repository.save(obj);
        return new DeviceDTO(obj);
    }
}
