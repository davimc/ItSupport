package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartRepository extends JpaRepository<Part, UUID> {

}
