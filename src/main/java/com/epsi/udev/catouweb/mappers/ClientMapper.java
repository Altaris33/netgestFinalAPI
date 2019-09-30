package com.epsi.udev.catouweb.mappers;

import com.epsi.udev.catouweb.database.entities.ClientEntity;
import com.epsi.udev.catouweb.database.entities.MaterielEntity;
import com.epsi.udev.catouweb.models.Client;
import com.epsi.udev.catouweb.models.ClientCreation;
import com.epsi.udev.catouweb.models.Materiel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MaterielMapper.class)
public interface ClientMapper {

    @Mapping(target = "materiels", qualifiedByName = "asBeanWithoutClient")
    Client asBean(ClientEntity entity);

    ClientEntity asEntity(ClientCreation clientCreation);

    ClientEntity asEntity(Client bean);
}
