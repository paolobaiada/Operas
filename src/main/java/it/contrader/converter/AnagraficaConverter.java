package it.contrader.converter;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaConverter extends AbstractConverter<Anagrafica,AnagraficaDTO>{
    @Autowired
    private UserConverter userConverter;

    @Override
    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO){
        return anagraficaDTO != null ? Anagrafica.builder()
                .idAnagrafica(anagraficaDTO.getIdAnagrafica())
                .user(userConverter.toEntity(anagraficaDTO.getUser()))
                .nome(anagraficaDTO.getNome())
                .cognome(anagraficaDTO.getCognome())
                .dataNascita(anagraficaDTO.getDataNascita())
                .genere(anagraficaDTO.getGenere())
                .nazione(anagraficaDTO.getNazione())
                .provincia(anagraficaDTO.getProvincia())
                .citta(anagraficaDTO.getCitta())
                .indirizzo(anagraficaDTO.getIndirizzo())
                .dataRegistrazione(anagraficaDTO.getDataRegistrazione())
                .build() : null;
    }//funziona sia con la vecchia notazione che con quella nuova ma quella nuova ti formatta meglio il codice per visualizzare eventuali errori

    @Override
    public AnagraficaDTO toDTO(Anagrafica anagrafica){
        return anagrafica != null ? AnagraficaDTO.builder()
                .idAnagrafica(anagrafica.getIdAnagrafica())
                .user(userConverter.toDTO(anagrafica.getUser()))
                .nome(anagrafica.getNome())
                .cognome(anagrafica.getCognome())
                .dataNascita(anagrafica.getDataNascita())
                .genere(anagrafica.getGenere())
                .nazione(anagrafica.getNazione())
                .provincia(anagrafica.getProvincia())
                .citta(anagrafica.getCitta())
                .indirizzo(anagrafica.getIndirizzo())
                .dataRegistrazione(anagrafica.getDataRegistrazione())
                .build() : null;
    }
}