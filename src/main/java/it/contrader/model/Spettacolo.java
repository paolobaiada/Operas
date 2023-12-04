package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
public class Spettacolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpettacolo;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_societafk")
    private Societa societa;

    private String nomeProdotto;

    private String tipologia;

    private double costo;

    private String codiceProdotto;

    private LocalTime orario;

    private String descrizione;

    @Column(name = "immagine", columnDefinition="LONGBLOB")
    private byte[] immagine;

    private Date dataInserimento;

    @PrePersist
    protected void onCreate() {
        dataInserimento = new Date(System.currentTimeMillis());
    }

}
