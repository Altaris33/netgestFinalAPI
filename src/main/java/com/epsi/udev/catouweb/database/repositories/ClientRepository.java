package com.epsi.udev.catouweb.database.repositories;

import com.epsi.udev.catouweb.database.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    Set<ClientEntity> findAll();
}
