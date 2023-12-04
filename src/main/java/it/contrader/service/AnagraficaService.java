package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.AnagraficaRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.SocietaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.Societa;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnagraficaService extends AbstractService<Anagrafica, AnagraficaDTO> {

    @Autowired
    private AnagraficaConverter converter;

    @Autowired
    private AnagraficaRepository repository;

    public AnagraficaDTO findByUser(Long id) {
        Anagrafica anagrafica = repository.findByUserId(id);
        return converter.toDTO(anagrafica);
    }
}
