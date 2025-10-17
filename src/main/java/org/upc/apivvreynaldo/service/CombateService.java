package org.upc.apivvreynaldo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.upc.apivvreynaldo.dto.CombateDTO;
import org.upc.apivvreynaldo.dto.JuezCombateCountDTO;
import org.upc.apivvreynaldo.model.Combate;
import org.upc.apivvreynaldo.repository.CombateRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombateService {
    private final CombateRepository combateRepository;
    private final ModelMapper modelMapper;

    public CombateService(CombateRepository combateRepository) {
        this.combateRepository = combateRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<CombateDTO> listarCombatesPorJuez(String nombreJuez) {
        List<Combate> combates = combateRepository.findByJuezNombreJuez(nombreJuez);
        return combates.stream()
                .map(this::convertirACombateDTO)
                .collect(Collectors.toList());
    }

    public List<JuezCombateCountDTO> contarCombatesPorJuez() {
        return combateRepository.countCombatesByJuez();
    }

    private CombateDTO convertirACombateDTO(Combate combate) {
        CombateDTO dto = modelMapper.map(combate, CombateDTO.class);
        if (combate.getJuez() != null) {
            dto.setNombreJuez(combate.getJuez().getNombreJuez());
        }
        return dto;
    }
}
