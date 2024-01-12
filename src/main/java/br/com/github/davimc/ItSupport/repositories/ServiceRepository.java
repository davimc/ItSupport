package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
