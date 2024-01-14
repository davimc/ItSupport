package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
