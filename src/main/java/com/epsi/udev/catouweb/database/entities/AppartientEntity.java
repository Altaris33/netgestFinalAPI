package com.epsi.udev.catouweb.database.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "appartient")
@Getter
@Setter
public class AppartientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity clientEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_personne", nullable = false)
    private PersonneEntity personneEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fonction", nullable = false)
    private FonctionEntity fonctionEntity;
}
