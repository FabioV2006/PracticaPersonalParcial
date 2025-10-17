package org.upc.apivvreynaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.upc.apivvreynaldo.dto.JuezCombateCountDTO;
import org.upc.apivvreynaldo.model.Combate;

import java.util.List;

public interface CombateRepository extends JpaRepository<Combate, Long> {

    // Para HU03: Listar combates por nombre de Juez
    List<Combate> findByJuezNombreJuez(String nombreJuez);

    // Para HU04: Contar combates por cada Juez
    @Query("SELECT new org.upc.apivvreynaldo.dto.JuezCombateCountDTO(j.nombreJuez, COUNT(c)) " +
            "FROM Combate c JOIN c.juez j " +
            "GROUP BY j.nombreJuez")
    List<JuezCombateCountDTO> countCombatesByJuez();
}