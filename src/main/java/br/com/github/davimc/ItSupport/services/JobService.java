package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.dto.job.JobNewDTO;
import br.com.github.davimc.ItSupport.dto.job.JobTotalDTO;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.repositories.JobRepository;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;
    


    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;


    protected Job find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Job.class));
    }

    public JobDTO findById(UUID id) {
        Job obj = (find(id));

        return new JobDTO(obj);
    }
    public Page<JobTotalDTO> findAll(Pageable pageable) {

        return repository.findAllJobView(pageable);
    }

    public JobDTO create(JobNewDTO dto){
        Job obj = dto.copyToEntity();
        obj.setDevices(deviceService.findAll(dto.getDeviceId()));
        obj.setTech(userService.find(dto.getTechId()));
        obj = repository.save(obj);
        obj = repository.save(obj);

        return new JobDTO(obj);
    }
}
