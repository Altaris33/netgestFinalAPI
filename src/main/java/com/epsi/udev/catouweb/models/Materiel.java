package com.epsi.udev.catouweb.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "client")
public class Materiel {

    private Integer id;
    private String libelle;
    private TypeMateriel typeMateriel;

    private Client client;
    private List<Interface> interfaces;
}
