package br.com.github.davimc.ItSupport.services;

import br.com.github.davimc.ItSupport.dto.job.*;
import br.com.github.davimc.ItSupport.entities.Device;
import br.com.github.davimc.ItSupport.entities.Job;
import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.entities.enums.JobStatus;
import br.com.github.davimc.ItSupport.entities.enums.JobType;
import br.com.github.davimc.ItSupport.repositories.JobRepository;
import br.com.github.davimc.ItSupport.services.exceptions.InternalValidationException;
import br.com.github.davimc.ItSupport.services.exceptions.ObjectNotFoundException;
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
//Esse é mais complexo do que achei
    //TODO pensar em como será feita a atualização de equipamentos
    //OP 1: lista vem com os equipamentos atuais sempre -> se houver menos, será removido, se houver mais será add
    //OP 2: lista vem com 0 ou vários ids, caso o id coincida o equipamento será removido, caso contrário, add

    //TODO está entrando, no pior dos casos, 4 vezes no banco de dados.
    // tentei fazer uma projection pra recuperar o job inteiro, mas ele busca até as entidades associadas e dá erro
    @Transactional
    public JobDTO update(UUID id, JobUpdateDTO dto) {
        Job obj = find(id);
        //Não é necessário garantir, pois o find já garante que há
        JobDetailsDTO details = repository.findJobDetails(id).get();


        //changeDevicesList()

        jobUpdate(obj, details, dto);

        obj.setUpdateAt();
        obj = repository.save(obj);

        return new JobDTO(obj);
    }
    //todo pensar em uma forma de diminuir essa quantidade de if
    private void jobUpdateValidations(JobDetailsDTO details, JobUpdateDTO dto) {
        List<String> errors = new ArrayList<>();
        errors.add((details.getStatus() == JobStatus.ENDED && JobStatus.toEnum(dto.getJobStatus()) != JobStatus.RETURNED)?
                "The Job is in a completed status and is only allowed to be placed as a return":null );
        //data fim não pode ser anterior a data início
        errors.add((dto.getFinishedAt() != null && details.getCreatedAt().isBefore(dto.getFinishedAt()))?
                null : "End date cannot be earlier than start date");
        errors.add(details.getDevicesId().isEmpty()?
            null:"The job cannot exist without at least one device");
        if( errors.stream().allMatch(Objects::nonNull))
            throw new InternalValidationException(errors);
    }
    private void jobUpdate(Job obj, JobDetailsDTO dto, JobUpdateDTO updateDTO) {
        jobUpdateValidations(dto,updateDTO);
        obj.setType(JobType.toEnum(updateDTO.getJobType()) != dto.getType()?
                JobType.toEnum(updateDTO.getJobType()):dto.getType());
        obj.setStatus(JobStatus.toEnum(updateDTO.getJobStatus()) != dto.getStatus()?
                JobStatus.toEnum(updateDTO.getJobStatus()):dto.getStatus());
        if(updateDTO.getTechId() != null && obj.getTech().getId() != updateDTO.getTechId() )
            obj.setTech(userService.findTech(updateDTO.getTechId()));

        obj.setFinishedAt(updateDTO.getFinishedAt() != null && updateDTO.getFinishedAt() != dto.getFinishedAt()?
                updateDTO.getFinishedAt() : dto.getFinishedAt());
        //if(jobdevices)...
    }
    //TODO pensar futuramente como será a lógica de exclusão, no sentido das tasks
    // Caso um dispostivo tenha tasks, principalmente tasks em aberto, deve ser excluído ou alguma outra forma
    private JobDetailsDTO changeDevicesList(JobDetailsDTO details, JobUpdateDTO updateDTO) {
        details.getDevicesId().forEach(d -> {
            if(updateDTO.getDevicesId().contains(d))
                details.getDevicesId().remove(d);
            else details.getDevicesId().add(d);
        });

        return details;
    }
}
