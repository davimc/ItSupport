package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Authorization;
import br.com.github.davimc.ItSupport.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
}
