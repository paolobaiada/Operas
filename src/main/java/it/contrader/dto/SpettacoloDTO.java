package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpettacoloDTO {

    private Long idSpettacolo;

    private SocietaDTO societa;

    private String nomeProdotto;

    private String tipologia;

    private double costo;

    private String codiceProdotto;

    private LocalTime orario;

    private String descrizione;

    private byte[] immagine;

    private Date dataInserimento;
}
