package org.upc.apivvreynaldo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuezCombateCountDTO {
    private String nombreJuez;
    private Long cantidadCombates;
}