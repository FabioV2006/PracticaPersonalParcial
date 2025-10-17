package org.upc.apivvreynaldo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.upc.apivvreynaldo.dto.CombateDTO;
import org.upc.apivvreynaldo.dto.JuezCombateCountDTO;
import org.upc.apivvreynaldo.service.CombateService;

import java.util.List;

@RestController
@RequestMapping("/cantidades") // RUTA SEGÚN TUS INICIALES
public class CombateController {

    private final CombateService combateService;

    public CombateController(CombateService combateService) {
        this.combateService = combateService;
    }

    // HU03: Visualizar la lista de combates arbitrados por un juez
    @GetMapping("/por-juez") // Ruta específica para evitar ambigüedad
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public ResponseEntity<?> visualizarCombatesPorJuez(@RequestParam("nombreJuez") String nombreJuez) {
        List<CombateDTO> combates = combateService.listarCombatesPorJuez(nombreJuez);
        if (combates.isEmpty()) {
            return new ResponseEntity<>("No existen combates registrados para este juez", HttpStatus.OK);
        }
        return new ResponseEntity<>(combates, HttpStatus.OK);
    }

    // HU04: Visualizar la cantidad de combates por cada juez
    @GetMapping("/total")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> visualizarCantidadCombatesPorJuez() {
        List<JuezCombateCountDTO> conteo = combateService.contarCombatesPorJuez();
        if (conteo.isEmpty()) {
            return new ResponseEntity<>("No hay combates registrados", HttpStatus.OK);
        }
        return new ResponseEntity<>(conteo, HttpStatus.OK);
    }
}