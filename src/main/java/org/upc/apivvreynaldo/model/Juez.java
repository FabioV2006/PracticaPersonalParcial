package org.upc.apivvreynaldo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "juez")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Juez {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juez")
    private Long idJuez;

    @Column
    private String nombreJuez;

    @Column
    private String aniosExperiencia;

    @Column
    private String categoria;

    @Column
    private LocalDate fechaRegistro = LocalDate.now();



}
