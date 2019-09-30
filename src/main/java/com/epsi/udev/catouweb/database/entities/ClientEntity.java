package com.epsi.udev.catouweb.database.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "client")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "materiels")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    private String nom;
    private String adresse1;
    private String adresse2;
    private Integer idcpville;

    @OneToMany(mappedBy = "client")
    private Set<MaterielEntity> materiels;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cp_ville", nullable = false)
    private VilleEntity villeEntity;
}
