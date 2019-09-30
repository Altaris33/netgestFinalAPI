package com.epsi.udev.catouweb.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "materiels")
public class Client {

    private Integer id;
    private String nom;
    private String adresse1;
    private String adresse2;
    private Integer idcpville;

    private List<Materiel> materiels;
}
