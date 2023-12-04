package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocietaDTO {

    private Long idSocieta;
    private AnagraficaDTO anagrafica;
    private String nome;
    private String descrizione;
    private String nazione;
    private String provincia;
    private String citta;
    private String indirizzo;

}
