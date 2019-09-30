package com.epsi.udev.catouweb.services;

import com.epsi.udev.catouweb.database.entities.AdresseIpEntity;
import com.epsi.udev.catouweb.database.entities.ClientEntity;
import com.epsi.udev.catouweb.database.entities.InterfaceEntity;
import com.epsi.udev.catouweb.database.entities.MaterielEntity;
import com.epsi.udev.catouweb.database.repositories.AdresseIpRepository;
import com.epsi.udev.catouweb.database.repositories.ClientRepository;
import com.epsi.udev.catouweb.database.repositories.InterfaceRepository;
import com.epsi.udev.catouweb.database.repositories.MaterielRepository;
import com.epsi.udev.catouweb.mappers.AdresseIpMapper;
import com.epsi.udev.catouweb.mappers.ClientMapper;
import com.epsi.udev.catouweb.mappers.InterfaceMapper;
import com.epsi.udev.catouweb.mappers.MaterielMapper;
import com.epsi.udev.catouweb.models.Client;
import com.epsi.udev.catouweb.models.ClientCreation;
import com.epsi.udev.catouweb.models.Materiel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientServices {

    private final ClientMapper clientMapper;
    private final MaterielMapper materielMapper;
    private final InterfaceMapper interfaceMapper;
    private final AdresseIpMapper adresseIpMapper;
    private final ClientRepository clientRepository;
    private final MaterielRepository materielRepository;
    private final InterfaceRepository interfaceRepository;
    private final AdresseIpRepository adresseIpRepository;

    public Set<Client> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::asBean)
                .collect(Collectors.toSet());
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::asBean);
    }

    public Client create(ClientCreation clientCreation) {
        return clientMapper.asBean(clientRepository.save(clientMapper.asEntity(clientCreation)));
    }

    @Transactional
    public Materiel addMaterial(Long clientId, Materiel materiel) {
        MaterielEntity materielEntity = materielMapper.asEntity(materiel);
        materielEntity.setClient(clientRepository.findById(clientId).get());
        MaterielEntity savedMaterielEntity = materielRepository.save(materielEntity);

        savedMaterielEntity.setInterfaces(materiel.getInterfaces()
                .stream()
                .map(interfaceBean -> {
                    InterfaceEntity interfaceEntity = interfaceMapper.asEntity(interfaceBean);
                    interfaceEntity.setMateriel(savedMaterielEntity);
                    InterfaceEntity savedInterfaceEntity = interfaceRepository.save(interfaceEntity);

                    AdresseIpEntity adresseIpEntity = adresseIpMapper.asEntity(interfaceBean.getAdresseIp());
                    adresseIpEntity.setInterfaceMateriel(savedInterfaceEntity);
                    AdresseIpEntity savedAdresseIpEntity = adresseIpRepository.save(adresseIpEntity);

                    savedInterfaceEntity.setAdresseIp(savedAdresseIpEntity);

                    return savedInterfaceEntity;
                })
                .collect(Collectors.toSet())
        );

        return materielMapper.asBeanWithoutClient(savedMaterielEntity);
    }

    @Transactional
    public void deleteMaterial(int clientId, int materialId) {
        materielRepository.findByIdAndClientId(materialId, clientId)
                .ifPresent(materielEntity -> {
                    materielEntity.getInterfaces().forEach(interfaceEntity -> {
                        if (interfaceEntity.getAdresseIp() != null) {
                            adresseIpRepository.delete(interfaceEntity.getAdresseIp());
                        }
                    });
                    interfaceRepository.deleteAll(materielEntity.getInterfaces());
                    materielRepository.delete(materielEntity);
                });
    }

    public Set<Materiel> getClientMaterielList(int clientId) {
        return materielRepository.findAllByClientId(clientId)
                .stream()
                .map(materielMapper::asBeanWithoutClient)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
