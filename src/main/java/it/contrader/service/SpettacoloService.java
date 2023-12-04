package it.contrader.service;

import it.contrader.converter.SocietaConverter;
import it.contrader.converter.SpettacoloConverter;
import it.contrader.dao.SpettacoloRepository;
import it.contrader.dto.SocietaDTO;
import it.contrader.dto.SpettacoloDTO;
import it.contrader.model.Societa;
import it.contrader.model.Spettacolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Service
public class SpettacoloService extends AbstractService<Spettacolo, SpettacoloDTO>{
    @Autowired
    private SpettacoloConverter spettacoloConverter;
    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @Autowired
    private SocietaConverter societaConverter;

    public List<SpettacoloDTO> findBySocietaIdSocieta(Long idSocieta) {

        List<Spettacolo> spettacolo = spettacoloRepository.findBySocietaIdSocieta(idSocieta);
        return spettacoloConverter.toDTOList(spettacolo);
    }
    public LinkedHashMap<Date,Integer> getStats(Long idSocieta){
        List<SpettacoloDTO> spettacolo = this.findBySocietaIdSocieta(idSocieta);
        Comparator<SpettacoloDTO> comparatoreData = Comparator.comparing(SpettacoloDTO :: getDataInserimento);
        spettacolo.sort(comparatoreData);
        LinkedHashMap<Date,Integer> statistica = new LinkedHashMap<>();
        for (SpettacoloDTO s : spettacolo){
            Date d = s.getDataInserimento();
            statistica.merge(d, 1, Integer::sum);
        }
        return statistica;
    }
    public SpettacoloDTO  insertSpettacolo(Spettacolo spettacolo){
        Spettacolo spettacolo1 =spettacoloRepository.save(spettacolo);
        return spettacoloConverter.toDTO(spettacolo1);
    }


    public List<SpettacoloDTO> findByTipologiaAndCostoAndOrario(String tipologia, double minCosto, double maxCosto, Time minOrario, Time maxOrario) {
        return spettacoloConverter.toDTOList(spettacoloRepository.findByTipologiaAndCostoBetweenAndOrarioBetween(tipologia, minCosto, maxCosto, minOrario, maxOrario));
    }

    public List<SpettacoloDTO> findByNomeProdottoContaining(String ricerca){
        return spettacoloConverter.toDTOList(spettacoloRepository.findByNomeProdottoContaining(ricerca));
    }
}
