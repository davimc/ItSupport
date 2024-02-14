
package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Task;
import br.com.github.davimc.ItSupport.entities.TaskPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskPartRepository extends JpaRepository<TaskPart, UUID> {

}
