package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
    @Query("SELECT d FROM Device d " +
            "WHERE d.owner.id = :ownerId")
    List<Device> findByOwner(UUID ownerId);
}
