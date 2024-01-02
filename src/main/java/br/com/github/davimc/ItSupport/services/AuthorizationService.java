package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.authorization.AuthorizationDTO;
import br.com.github.davimc.ItSupport.dto.authorization.AuthorizationNewDTO;
import br.com.github.davimc.ItSupport.dto.part.PartDTO;
import br.com.github.davimc.ItSupport.dto.part.PartNewDTO;
import br.com.github.davimc.ItSupport.entities.Authorization;
import br.com.github.davimc.ItSupport.entities.Part;
import br.com.github.davimc.ItSupport.repositories.AuthorizationRepository;
import br.com.github.davimc.ItSupport.repositories.PartRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
    private AuthorizationRepository repository;
    @Autowired
    private PartService partService;
    protected Authorization find(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException(id, Authorization.class));
    }

    public AuthorizationDTO findById(Long id) {
        return new AuthorizationDTO(find(id));
    }

    public Page<AuthorizationDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(AuthorizationDTO::new);
    }

    public AuthorizationDTO create(AuthorizationNewDTO dto) {
        try {
            Authorization obj = dto.copyToEntity();
            obj = repository.save(obj);

            return new AuthorizationDTO(obj);
        }catch (ObjectNotFoundException e) {
            throw new IllegalArgumentException("Unrecognized parameter");
        }
    }
}
