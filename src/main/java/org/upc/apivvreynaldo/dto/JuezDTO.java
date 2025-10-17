package org.upc.apivvreynaldo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuezDTO {
    private Long id;
    private String nombre;
    private String aniosExperiencia;
    private String categoria;

}
