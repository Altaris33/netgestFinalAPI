package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdresseIp {

    private Integer id;
    private String ipV4;
    private String ipV6;
    private String masque;

    private TypeAffectation typeAffectation;
    private Interface interfaceMateriel;
}
