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

    @Query("SELECT new br.com.github.davimc.ItSupport.dto.job.JobTotalDTO( " +
            "    j.id, j.os, j.status, j.createdAt, j.type, j.finishedAt,  c.name, tc.name, " +
            "    COALESCE(SUM(t.amount), 0)) " +
            "FROM Job j " +
            "LEFT JOIN j.tasks t " +
            "INNER JOIN j.devices d " +
            "INNER JOIN d.owner c " +
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