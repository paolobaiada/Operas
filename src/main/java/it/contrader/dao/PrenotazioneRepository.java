package it.contrader.dao;

import it.contrader.model.Anagrafica;
import it.contrader.model.Prenotazione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
    List<Prenotazione> findByAnagrafica(Anagrafica anagrafica);

    List<Prenotazione> findByAnagraficaIdAnagrafica(Long idAnagrafica);
}
