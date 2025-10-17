package org.upc.apivvreynaldo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombateDTO {
    private Long IdCombate;
    private String Ronda;
    private String Competidor1;
    private String Competidor2;
    private Integer PuntosCompetidor1;
    private Integer PuntosCompetidor2;
    private String nombreJuez; // Para mostrar el nombre del juez
}