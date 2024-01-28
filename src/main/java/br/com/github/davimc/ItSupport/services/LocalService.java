package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.local.LocalNewDTO;
import br.com.github.davimc.ItSupport.dto.local.LocalDTO;
import br.com.github.davimc.ItSupport.entities.Local;
import br.com.github.davimc.ItSupport.repositories.LocalRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocalService {
    @Autowired
    private LocalRepository repository;

    protected Local find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Local.class));
    }

    public LocalDTO findById(UUID id) {
        Local obj = find(id);

        return new LocalDTO(obj);
    }
    public Page<LocalDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(LocalDTO::new);
    }

    public LocalDTO create(LocalNewDTO newDTO){
        Local obj = newDTO.copyToEntity();
        obj = repository.save(obj);

        return new LocalDTO(obj);
    }
}
