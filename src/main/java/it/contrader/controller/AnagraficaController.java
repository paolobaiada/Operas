package it.contrader.controller;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import it.contrader.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/anagrafica")
@CrossOrigin(origins = "http://localhost:4200")
public class AnagraficaController extends AbstractController<AnagraficaDTO>{

    @Autowired
    private AnagraficaService anagraficaService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registeranagrafica")
    public ResponseEntity<AnagraficaDTO> register(@RequestBody @Valid AnagraficaDTO anagraficaDTO){
        return new ResponseEntity<>(anagraficaService.insert(anagraficaDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/readAnagrafica/{id}")
    public AnagraficaDTO read(@PathVariable Long id){
        return (AnagraficaDTO) anagraficaService.findByUser(id);
    }

    @PatchMapping( value = "/updateanagrafica/{idAnagrafica}")
    public ResponseEntity<AnagraficaDTO> updateAnagrafica(@PathVariable Long idAnagrafica, @RequestBody @Valid AnagraficaDTO anagraficaDTO) {
        AnagraficaDTO anagrafica = anagraficaService.read(idAnagrafica);
        if(anagraficaDTO.getNome()!= null){
            anagrafica.setNome(anagraficaDTO.getNome());
        }
        if(anagraficaDTO.getCognome()!= null){
            anagrafica.setCognome(anagraficaDTO.getCognome());
        }
        if(anagraficaDTO.getDataNascita()!= null){
            anagrafica.setDataNascita(anagraficaDTO.getDataNascita());
        }
        if(anagraficaDTO.getGenere()!= '\0'){
            anagrafica.setGenere(anagraficaDTO.getGenere());
        }
        if(anagraficaDTO.getNazione()!= null){
            anagrafica.setNazione(anagraficaDTO.getNazione());
        }
        if(anagraficaDTO.getProvincia()!= null){
            anagrafica.setProvincia(anagraficaDTO.getProvincia());
        }
        if(anagraficaDTO.getCitta()!= null){
            anagrafica.setCitta(anagraficaDTO.getCitta());
        }
        if(anagraficaDTO.getIndirizzo()!= null){
            anagrafica.setIndirizzo(anagraficaDTO.getIndirizzo());
        }

        return new ResponseEntity<>(anagraficaService.update(anagrafica), HttpStatus.OK);
    }
}