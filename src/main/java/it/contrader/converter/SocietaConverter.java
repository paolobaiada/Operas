package it.contrader.converter;

import it.contrader.dto.SocietaDTO;
import it.contrader.model.Societa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocietaConverter extends AbstractConverter<Societa, SocietaDTO> {

    @Autowired
    private AnagraficaConverter anagraficaConverter;
    @Override
    public Societa toEntity(SocietaDTO societaDTO) {
        return societaDTO != null ? Societa.builder()
                .idSocieta(societaDTO.getIdSocieta())
                .anagrafica(anagraficaConverter.toEntity(societaDTO.getAnagrafica()))
                .nome(societaDTO.getNome())
                .descrizione(societaDTO.getDescrizione())
                .nazione(societaDTO.getNazione())
                .provincia(societaDTO.getProvincia())
                .citta(societaDTO.getCitta())
                .indirizzo(societaDTO.getIndirizzo())
                .build() : null;
    }

    @Override
    public SocietaDTO toDTO(Societa societa) {
        return societa != null ? SocietaDTO.builder()
                .idSocieta(societa.getIdSocieta())
                .anagrafica(anagraficaConverter.toDTO(societa.getAnagrafica()))
                .nome(societa.getNome())
                .descrizione(societa.getDescrizione())
                .nazione(societa.getNazione())
                .provincia(societa.getProvincia())
                .citta(societa.getCitta())
                .indirizzo(societa.getIndirizzo())
                .build() : null;
    }

}
