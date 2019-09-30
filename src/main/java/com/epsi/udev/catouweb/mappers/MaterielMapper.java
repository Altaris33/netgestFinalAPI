package com.epsi.udev.catouweb.mappers;

import com.epsi.udev.catouweb.database.entities.MaterielEntity;
import com.epsi.udev.catouweb.models.Materiel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {InterfaceMapper.class})
public interface MaterielMapper {

    @Named("asBeanWithoutClient")
    @Mapping(target = "client", ignore = true)
    Materiel asBeanWithoutClient(MaterielEntity entity);

    Materiel asBean(MaterielEntity entity);

    @Mapping(target = "client", ignore = true)
    @Mapping(target = "interfaces", ignore = true)
    MaterielEntity asEntity(Materiel bean);
}
