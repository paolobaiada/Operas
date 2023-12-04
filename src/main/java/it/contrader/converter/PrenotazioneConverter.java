package it.contrader.converter;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioneConverter extends AbstractConverter<Prenotazione, PrenotazioneDTO>{
    @Autowired
    private AnagraficaConverter anagraficaConverter;

    @Autowired
    private SpettacoloConverter spettacoloConverter;

    @Override
    public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO) {
        return prenotazioneDTO != null ? Prenotazione.builder()
                .idPrenotazione(prenotazioneDTO.getIdPrenotazione())
                .anagrafica(anagraficaConverter.toEntity(prenotazioneDTO.getAnagrafica()))
                .spettacolo(spettacoloConverter.toEntity(prenotazioneDTO.getSpettacolo()))
                .data(prenotazioneDTO.getData())
                .numeroOrdine(prenotazioneDTO.getNumeroOrdine())
                .costo(prenotazioneDTO.getCosto())
                .build() : null;
    }

    @Override
    public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
        return prenotazione != null ? PrenotazioneDTO.builder()
                .idPrenotazione(prenotazione.getIdPrenotazione())
                .anagrafica(anagraficaConverter.toDTO(prenotazione.getAnagrafica()))
                .spettacolo(spettacoloConverter.toDTO(prenotazione.getSpettacolo()))
                .data(prenotazione.getData())
                .numeroOrdine(prenotazione.getNumeroOrdine())
                .costo(prenotazione.getCosto())
                .build() : null;
    }
}
