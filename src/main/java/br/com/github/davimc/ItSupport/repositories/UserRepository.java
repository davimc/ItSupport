package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
