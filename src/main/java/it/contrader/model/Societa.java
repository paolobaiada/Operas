package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Societa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocieta;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_anagraficafk")
    private Anagrafica anagrafica;

    private String nome;
    private String descrizione;
    private String nazione;

    @Column(name = "provincia", length = 2)
    private String provincia;

    private String citta;
    private String indirizzo;
}