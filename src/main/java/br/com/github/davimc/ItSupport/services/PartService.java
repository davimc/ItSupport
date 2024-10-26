package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartNewDTO;
import br.com.github.davimc.ItSupport.dto.part.PartUpdateDTO;
import br.com.github.davimc.ItSupport.entities.Part;
import br.com.github.davimc.ItSupport.repositories.PartRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartService {
    @Autowired
    private PartRepository repository;
    @Autowired
    private LocalService localService;

    protected Part find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Part.class));
    }

    public PartDTO findById(UUID id) {
        Part obj = find(id);

        return new PartDTO(obj);
    }
    public Page<PartDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(PartDTO::new);
    }

    public PartDTO create(PartNewDTO newDTO){
        Part obj = newDTO.copyToEntity();
        obj.setLocal(localService.find(newDTO.getLocalId()));

        obj = repository.save(obj);
        return new PartDTO(obj);
    }

    public PartDTO update (UUID id, PartUpdateDTO dto) {
        Part obj = find(id);

        obj = dto.fromEntity(obj);
        if(dto.getLocalId() != null)
            obj.setLocal(localService.find(dto.getLocalId()));

        obj = repository.save(obj);
        return new PartDTO(obj);
    }
}
