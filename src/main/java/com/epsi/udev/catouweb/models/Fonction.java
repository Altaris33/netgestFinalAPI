package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Fonction {

    private Integer id;
    private String libelle;
    private Appartient appartient;
}
