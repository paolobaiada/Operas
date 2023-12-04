package it.contrader.service;

import it.contrader.converter.PrenotazioneConverter;
import it.contrader.dao.PrenotazioneRepository;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService extends AbstractService<Prenotazione, PrenotazioneDTO> {

    @Autowired
    private PrenotazioneConverter prenotazioneConverter;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<PrenotazioneDTO> getStorico(Long idAnagrafica){
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByAnagraficaIdAnagrafica(idAnagrafica);
        return prenotazioneConverter.toDTOList(prenotazioni);
    }

}
