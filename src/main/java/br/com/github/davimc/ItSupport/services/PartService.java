package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartNewDTO;
import br.com.github.davimc.ItSupport.entities.Part;
import br.com.github.davimc.ItSupport.repositories.PartRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartService {
    @Autowired
    private PartRepository repository;
    protected Part find(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException(id, Part.class));
    }

    public PartDTO findById(Long id) {
        return new PartDTO(find(id));
    }

    public Page<PartDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(PartDTO::new);
    }

    public PartDTO create(PartNewDTO dto) {
        Part obj = dto.copyToEntity();
        obj = repository.save(obj);

        return new PartDTO(obj);
    }
}
