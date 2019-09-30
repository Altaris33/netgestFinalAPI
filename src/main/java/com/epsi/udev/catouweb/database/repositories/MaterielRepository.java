package com.epsi.udev.catouweb.database.repositories;

import com.epsi.udev.catouweb.database.entities.MaterielEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface MaterielRepository extends CrudRepository<MaterielEntity, Integer> {

    Optional<MaterielEntity> findByIdAndClientId(Integer id, Integer clientId);

    Set<MaterielEntity> findAllByClientId(int clientId);

}
