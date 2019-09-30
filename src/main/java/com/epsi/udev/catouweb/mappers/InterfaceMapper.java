package com.epsi.udev.catouweb.mappers;

import com.epsi.udev.catouweb.database.entities.InterfaceEntity;
import com.epsi.udev.catouweb.models.Interface;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AdresseIpMapper.class})
public interface InterfaceMapper {

    @Mapping(target = "materiel", ignore = true)
    Interface asBean(InterfaceEntity entity);

    @Mapping(target = "materiel", ignore = true)
    @Mapping(target = "adresseIp", ignore = true)
    InterfaceEntity asEntity(Interface bean);

}
