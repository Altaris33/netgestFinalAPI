package com.epsi.udev.catouweb.mappers;

import com.epsi.udev.catouweb.database.entities.AdresseIpEntity;
import com.epsi.udev.catouweb.database.entities.InterfaceEntity;
import com.epsi.udev.catouweb.models.AdresseIp;
import com.epsi.udev.catouweb.models.Interface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdresseIpMapper {

    @Mapping(target = "interfaceMateriel", ignore = true)
    AdresseIp asBean(AdresseIpEntity entity);

    AdresseIpEntity asEntity(AdresseIp bean);
}
