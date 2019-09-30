package com.epsi.udev.catouweb.database.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "materiel")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"client", "typeMateriel"})
public class MaterielEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type", nullable = false)
    private TypeMaterielEntity typeMateriel;

    @OneToMany(mappedBy = "materiel")
    private Set<InterfaceEntity> interfaces;
}
