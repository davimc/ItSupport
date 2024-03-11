package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}
