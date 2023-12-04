package it.contrader.dao;


import it.contrader.dto.UserDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AnagraficaRepository extends CrudRepository<Anagrafica, Long> {


    Anagrafica findByUserId(Long id);

}