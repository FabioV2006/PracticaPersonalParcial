package org.upc.apivvreynaldo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.upc.apivvreynaldo.dto.JuezDTO;
import org.upc.apivvreynaldo.model.Juez;
import org.upc.apivvreynaldo.service.JuezService;

@RestController
@RequestMapping("/Reynaldo")
public class JuezController {

    private final JuezService juezService;

    public JuezController(JuezService juezService) {
        this.juezService = juezService;
    }
    @PostMapping("/registrar")
    @PreAuthorize("hasRole('CLIMA')")
    public ResponseEntity<JuezDTO> registrarJuez(@Valid @RequestBody JuezDTO juezDTO){
        return new ResponseEntity<>(juezService.Registrar(juezDTO), HttpStatus.CREATED);
    }
}
