package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {


    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = """
            SELECT tb_users.email AS username, tb_users.password, tb_role.id AS roleId, tb_role.authority, tb_users.name, tb_users.obs
            FROM tb_users 
            INNER JOIN tb_user_role ON tb_users.id = tb_user_role.user_id
            INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id
            WHERE tb_users.email = :email 
            """)
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
