package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalRepository extends JpaRepository<Local, UUID> {

}
