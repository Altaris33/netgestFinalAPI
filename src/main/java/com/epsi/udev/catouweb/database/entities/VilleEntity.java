package com.epsi.udev.catouweb.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name= "ville")
@Getter
@Setter
public class VilleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codePostal;
    private String ville;


}
