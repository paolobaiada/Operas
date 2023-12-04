package it.contrader.dao;

import it.contrader.model.Societa;
import it.contrader.model.Spettacolo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;

@Repository
@Transactional
public interface SpettacoloRepository extends CrudRepository<Spettacolo, Long> {

    List<Spettacolo> findBySocietaIdSocieta(Long idSocieta);

    List<Spettacolo> findByTipologiaAndCostoBetweenAndOrarioBetween(String tipologia, double minCosto, double maxCosto, Time minOrario, Time maxOrario);

    List<Spettacolo> findByNomeProdottoContaining(String ricerca);
}
