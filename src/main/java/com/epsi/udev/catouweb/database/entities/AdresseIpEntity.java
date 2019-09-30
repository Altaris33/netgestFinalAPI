package com.epsi.udev.catouweb.database.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "adresse_ip")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"interfaceMateriel", "typeAffectation"})
public class AdresseIpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ipV4")
    private String ipV4;
    @Column(name = "ipV6")
    private String ipV6;
    private String masque;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_interface", nullable = false)
    private InterfaceEntity interfaceMateriel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_aff", nullable = false)
    private TypeAffectationEntity typeAffectation;
}
