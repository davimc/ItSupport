package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.dto.job.JobDetailsDTO;
import br.com.github.davimc.ItSupport.dto.job.JobTotalDTO;
import br.com.github.davimc.ItSupport.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
//todo está errado a forma de chamar o tb_tasks, tem que comparar o id
    // todo fazer join com usuário para que busque o cliente e técnico

    @Query("SELECT new br.com.github.davimc.ItSupport.dto.job.JobTotalDTO( " +
            "    j.id, j.os, j.status, j.createdAt, j.type, j.finishedAt,  c.name, tc.name, " +
            "    COALESCE(SUM(t.amount), 0)) " +
            "FROM Job j " +
            "LEFT JOIN j.tasks t " +
            "INNER JOIN j.devices d " +
            "INNER JOIN d.user c " +
            "INNER JOIN j.tech tc " +
            "GROUP BY j.os, j.status, j.createdAt, j.type, j.finishedAt, tc.name, c.name")
    Page<JobTotalDTO> findAllJobView(Pageable pageable);

    @Query("SELECT new br.com.github.davimc.ItSupport.dto.job.JobDetailsDTO(" +
            "j.id, j.status, j.type, j.createdAt, j.finishedAt," +
            "GROUP_CONCAT(d.id) AS devicesId, " +
            "u.id AS techId) " +
            "FROM Job j " +
            "INNER JOIN j.devices d " +
            "INNER JOIN j.tech u " +
            "WHERE j.id = :id")
    Optional<JobDetailsDTO> findJobDetails(UUID id);

}



/*
SELECT  " +
        "   (cast J.id AS VARCHAR) AS id, J.OS, J.STATUS, J.CREATED_AT, J.TYPE, J.FINISHED_AT, TC.NAME AS TECH_NAME, C.NAME AS CLIENT_NAME,  " +
        "    COALESCE(T.TOTAL_AMOUNT, 0) AS TOTAL " +
        "FROM tb_jobs AS J " +
        "LEFT JOIN ( " +
        "    SELECT T.JOB_ID, SUM(T.AMOUNT) AS TOTAL_AMOUNT " +
        "    FROM tb_tasks AS T " +
        "    GROUP BY T.JOB_ID " +
        ") AS T ON J.ID = T.JOB_ID " +
        "INNER JOIN tb_jobs_devices AS JD ON J.ID = JD.JOB_ID " +
        "INNER JOIN tb_devices AS D ON D.ID = JD.DEVICE_ID " +
        "INNER JOIN tb_users AS C ON C.ID = D.OWNER_ID " +
        "INNER JOIN tb_users AS TC ON TC.ID = J.TECHNICIAN_ID  " +
        "GROUP BY    J.OS; "*/