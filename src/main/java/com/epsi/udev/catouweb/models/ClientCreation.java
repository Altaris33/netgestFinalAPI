package com.epsi.udev.catouweb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientCreation {

    private Integer id;
    private String nom;
    private String adresse1;
    private String adresse2;
    private Integer idcpville;
}
