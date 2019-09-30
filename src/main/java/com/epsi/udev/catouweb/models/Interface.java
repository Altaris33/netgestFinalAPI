package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Interface {

    private Integer id;
    private String nom;
    private String mac;
    private TypeInterface typeInterface;
    private Materiel materiel;
    private AdresseIp adresseIp;
}
