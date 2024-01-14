package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalRepository extends JpaRepository<Local, UUID> {

}
