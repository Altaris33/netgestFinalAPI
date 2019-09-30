package com.epsi.udev.catouweb.database.entities;

import com.epsi.udev.catouweb.models.Interface;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "interface")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"typeInterface", "materiel"})
public class InterfaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String mac;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type", nullable = false)
    private TypeInterfaceEntity typeInterface;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materiel", nullable = false)
    private MaterielEntity materiel;

    @OneToOne(mappedBy = "interfaceMateriel", fetch = FetchType.EAGER)
    private AdresseIpEntity adresseIp;
}
