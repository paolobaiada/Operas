package it.contrader.dto;


import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnagraficaDTO {
    private Long idAnagrafica;
    private UserDTO user;
    private String nome;
    private String cognome;
    private String dataNascita;
    private char genere;
    private String nazione;
    private String provincia;
    private String citta;
    private String indirizzo;
    private Date dataRegistrazione;
}
