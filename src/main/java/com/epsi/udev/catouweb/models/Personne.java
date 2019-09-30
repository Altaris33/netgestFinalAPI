package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Personne {

    private Integer id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private Appartient appartient;
}
