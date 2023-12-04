package it.contrader.converter;

import it.contrader.dto.SpettacoloDTO;
import it.contrader.model.Spettacolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpettacoloConverter extends AbstractConverter<Spettacolo, SpettacoloDTO>{

    @Autowired
    private SocietaConverter societaConverter;
    @Override
    public Spettacolo toEntity(SpettacoloDTO spettacoloDTO) {
        return spettacoloDTO != null ? Spettacolo.builder()
                .idSpettacolo(spettacoloDTO.getIdSpettacolo())
                .societa(societaConverter.toEntity(spettacoloDTO.getSocieta()))
                .nomeProdotto(spettacoloDTO.getNomeProdotto())
                .tipologia(spettacoloDTO.getTipologia())
                .costo(spettacoloDTO.getCosto())
                .codiceProdotto(spettacoloDTO.getCodiceProdotto())
                .orario(spettacoloDTO.getOrario())
                .descrizione(spettacoloDTO.getDescrizione())
                .immagine(spettacoloDTO.getImmagine())
                .dataInserimento(spettacoloDTO.getDataInserimento())
                .build() : null;
    }

    @Override
    public SpettacoloDTO toDTO(Spettacolo spettacolo) {
        return spettacolo != null ? SpettacoloDTO.builder()
                .idSpettacolo(spettacolo.getIdSpettacolo())
                .societa(societaConverter.toDTO(spettacolo.getSocieta()))
                .nomeProdotto(spettacolo.getNomeProdotto())
                .tipologia(spettacolo.getTipologia())
                .costo(spettacolo.getCosto())
                .codiceProdotto(spettacolo.getCodiceProdotto())
                .orario(spettacolo.getOrario())
                .descrizione(spettacolo.getDescrizione())
                .immagine(spettacolo.getImmagine())
                .dataInserimento(spettacolo.getDataInserimento())
                .build() : null;
    }
}
