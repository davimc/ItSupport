package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.jobDescription.JobDescriptionDTO;
import br.com.github.davimc.ItSupport.dto.jobDescription.JobDescriptionNewDTO;
import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.JobDescription;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.repositories.JobDescriptionRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JobDescriptionService {

    @Autowired
    private JobDescriptionRepository repository;
    @Autowired
    private DeviceService deviceService;
    protected JobDescription find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, JobDescription.class));
    }

    public JobDescriptionDTO findById(UUID id) {
        return new JobDescriptionDTO(find(id));
    }

    public Set<JobDescription> saveAll(Job job, List<JobDescriptionNewDTO> dto) {
        List<JobDescription> descriptions =  dto.stream().map(x -> {
            Device d = deviceService.find(x.device());
            return new JobDescription(null, d, job, JobType.toEnum(x.type()), x.description());
        }).toList();
        return new HashSet<JobDescription>(repository.saveAll(descriptions));
    }
}


