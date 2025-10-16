package org.upc.apivvreynaldo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.upc.apivvreynaldo.dto.JuezDTO;
import org.upc.apivvreynaldo.model.Juez;
import org.upc.apivvreynaldo.repository.JuezRepository;

@Service
public class JuezService {
    private final JuezRepository JuezRepositurory;
    public JuezService(JuezRepository juezRepository) {this.JuezRepositurory = juezRepository; }

    public JuezDTO Registrar (JuezDTO juezDTO) {
        //Validaciones

        ModelMapper modelMapper = new ModelMapper();
        Juez juez = modelMapper.map(juezDTO,Juez.class);
        juez = JuezRepositurory.save(juez);
        return modelMapper.map(juez, JuezDTO.class);


    }

}
