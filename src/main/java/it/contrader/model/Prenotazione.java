package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrenotazione;

    @ManyToOne
    @JoinColumn(name="anagrafica_id_anagrafica")
    private Anagrafica anagrafica;
    @ManyToOne
    @JoinColumn(name="spettacolo_id_spettacolo")
    private Spettacolo spettacolo;

    private Date data;

    @Column(name = "numero_ordine")
    private String numeroOrdine;

    @Column(name = "costo")
    private double costo;

    @PrePersist
    protected void onCreate() {
        data = new Date(System.currentTimeMillis());
    }
}
