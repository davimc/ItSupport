package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.job.JobDTO;
import br.com.github.davimc.ItSupport.dto.job.JobNewDTO;
import br.com.github.davimc.ItSupport.dto.job.JobTotalDTO;
import br.com.github.davimc.ItSupport.dto.job.JobUpdateDTO;
import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.JobRepository;
import br.com.github.davimc.ItSupport.services.exceptions.InternalValidationException;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
import ch.qos.logback.core.util.IncompatibleClassException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;
    


    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    protected Job find(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Job.class));
    }

    @Transactional(readOnly = true)
    public JobDTO findById(UUID id) {
        Job obj = (find(id));

        return new JobDTO(obj);
    }
    public Page<JobTotalDTO> findAll(Pageable pageable) {

        return repository.findAllJobView(pageable);
    }

    @Transactional
    public JobDTO create(JobNewDTO dto){
        Set<Device> devices = deviceService.findAll(dto.getDevicesId());
        User tech = userService.findTech(dto.getTechId());

        Job obj = dto.copyToEntity();
        obj.setTech(tech);
        obj.setDevices(devices);


        obj = repository.save(obj);

        return new JobDTO(obj);
    }

    @Transactional
    public JobDTO update(UUID id, JobUpdateDTO updateDTO) {
        Job obj = find(id);
        jobUpdateValidations(obj, updateDTO);
        obj = updateDTO.copyToEntity(obj);
        obj = repository.save(obj);

        return new JobDTO(obj);
    }
//Esse é mais complexo do que achei
    //TODO pensar em como será feita a atualização de equipamentos
    //OP 1: lista vem com os equipamentos atuais sempre -> se houver menos, será removido, se houver mais será add
    //OP 2: lista vem com 0 ou vários ids, caso o id coincida o equipamento será removido, caso contrário, add
    private void jobUpdateValidations(Job obj, JobUpdateDTO dto) {
        List<String> errors = new ArrayList<>();
        errors.add((dto.getFinishedAt() != null && obj.getCreatedAt().isBefore(dto.getFinishedAt()))?
                null : "End date cannot be earlier than start date");

        if( errors.stream().allMatch(Objects::isNull))
            throw new InternalValidationException(errors);
    }
}
