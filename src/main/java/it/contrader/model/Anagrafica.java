package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
public class Anagrafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnagrafica;

    @OneToOne(cascade = CascadeType.MERGE)

    @JoinColumn(name="id_userfk")
    private User user;
    private String nome;
    private String cognome;
    private String dataNascita;
    private char genere;
    private String nazione;
    @Column(name = "provincia", length = 2)
    private String provincia;
    private String citta;
    private String indirizzo;
    @Column(name = "data_registrazione")
    private Date dataRegistrazione;

    @PrePersist
    protected void onCreate() {
        dataRegistrazione = new Date(System.currentTimeMillis());;
    }

}