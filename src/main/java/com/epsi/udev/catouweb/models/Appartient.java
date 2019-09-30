package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Appartient {

    private Integer id;
    private Integer idPersonne;
    private Integer idFonction;
    private Integer idClient;
    private Client client;
    private Fonction fonction;
    private Personne personne;
}
