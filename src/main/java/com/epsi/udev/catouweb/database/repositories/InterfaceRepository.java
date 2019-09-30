package com.epsi.udev.catouweb.database.repositories;

import com.epsi.udev.catouweb.database.entities.ClientEntity;
import com.epsi.udev.catouweb.database.entities.InterfaceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface InterfaceRepository extends CrudRepository<InterfaceEntity, Integer> {


}
