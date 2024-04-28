package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobDescriptionRepository extends JpaRepository<JobDescription, UUID> {
}