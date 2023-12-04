package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.converter.SocietaConverter;
import it.contrader.dao.SocietaRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.SocietaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.Societa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocietaService extends AbstractService<Societa, SocietaDTO> {

    @Autowired
    private SocietaConverter societaConverter;

    @Autowired
    private SocietaRepository societaRepository;

    public SocietaDTO findByAnagrafica(Long idAnagrafica) {
        Societa societa = societaRepository.findByAnagraficaIdAnagrafica(idAnagrafica);
        return societaConverter.toDTO(societa);
    }

}
