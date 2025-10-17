package org.upc.apivvreynaldo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.upc.apivvreynaldo.dto.JuezDTO;
import org.upc.apivvreynaldo.model.Juez;
import org.upc.apivvreynaldo.repository.JuezRepository;

@Service
public class JuezService {
    private final JuezRepository juezRepository;
    private final ModelMapper modelMapper;

    public JuezService(JuezRepository juezRepository) {
        this.juezRepository = juezRepository;
        this.modelMapper = new ModelMapper();
    }

    public Juez registrarJuez(JuezDTO juezDTO) {
        Juez juez = modelMapper.map(juezDTO, Juez.class);
        return juezRepository.save(juez);
    }

}
