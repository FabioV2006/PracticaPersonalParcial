package org.upc.apivvreynaldo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "combate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Combate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_combate")
    private Long idCombate;

    @Column
    private String ronda;

    @Column
    private String competidor1;

    @Column
    private String competidor2;

    @Column
    private Integer puntosCompetidor1;

    @Column
    private Integer puntosCompetidor2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_juez", referencedColumnName = "id_juez")
    private Juez juez;
}
