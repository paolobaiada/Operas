package it.contrader.dao;

import it.contrader.model.Anagrafica;
import it.contrader.model.Societa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface SocietaRepository extends CrudRepository<Societa, Long> {

    Societa findByAnagraficaIdAnagrafica(Long idAnagrafica);

}
