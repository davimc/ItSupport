package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

}
