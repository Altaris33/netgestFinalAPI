package com.epsi.udev.catouweb.controllers;

import com.epsi.udev.catouweb.models.Client;
import com.epsi.udev.catouweb.models.ClientCreation;
import com.epsi.udev.catouweb.models.Materiel;
import com.epsi.udev.catouweb.services.ClientServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Resource
    private ClientServices clientServices;

    @GetMapping
    public Set<Client> findAll() {
        return clientServices.findAll();
    }

    @GetMapping("/{clientId}")
    public Optional<Client> findById(@PathVariable("clientId") Long clientId) {
        return clientServices.findById(clientId);
    }

    @PostMapping
    public Client create(@RequestBody ClientCreation clientCreation) {
        return clientServices.create(clientCreation);
    }

    @GetMapping("/{clientId}/materiels")
    public Set<Materiel> getClientMaterielList(@PathVariable("clientId") int clientId){
        return clientServices.getClientMaterielList(clientId);
    }


    @PostMapping("/{clientId}/materiels")
    public Materiel addMaterial(@PathVariable("clientId") Long clientId, @RequestBody Materiel materiel) {
        return clientServices.addMaterial(clientId, materiel);
    }
    @DeleteMapping("/{clientId}/materiels/{materielId}")
    public void deleteMaterial(@PathVariable("clientId") int clientId, @PathVariable("materielId") int materielId) {
        clientServices.deleteMaterial(clientId, materielId);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId){
        clientServices.deleteClient(clientId);
    }

}
