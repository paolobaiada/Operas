package it.contrader.controller;

import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.SocietaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AnagraficaService;
import it.contrader.service.SocietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/societa")
@CrossOrigin(origins = "http://localhost:4200/")
public class SocietaController extends AbstractController<SocietaDTO>{

    @Autowired
    private SocietaService societaService;

    @Autowired
    private AnagraficaService anagraficaService;

    @PostMapping(value = "/registersocieta")
    public ResponseEntity<SocietaDTO> societaregister(@RequestBody @Valid SocietaDTO societaDTO){
        return new ResponseEntity<SocietaDTO>(societaService.insert(societaDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/readSocieta/{idAnagrafica}")
    public SocietaDTO read(@PathVariable Long idAnagrafica){
        return (SocietaDTO) societaService.findByAnagrafica(idAnagrafica);
    }

    @PatchMapping( value = "/updatesocieta")
    public ResponseEntity<SocietaDTO> updateSocieta(@RequestParam ("id") Long idSocieta, @RequestBody @Valid SocietaDTO societaDTO) {
        SocietaDTO societa = societaService.read(idSocieta);
        if(societaDTO.getNome()!= null) {
            societa.setNome(societaDTO.getNome());
        }
        if(societaDTO.getDescrizione()!= null){
        societa.setDescrizione(societaDTO.getDescrizione());
        }
        if(societaDTO.getNazione()!=null){
            societa.setNazione(societaDTO.getNazione());
        }
        if(societaDTO.getProvincia()!= null) {
            societa.setProvincia(societaDTO.getProvincia());
        }
        if(societaDTO.getCitta()!= null){
            societa.setCitta(societaDTO.getCitta());
        }
        if(societaDTO.getIndirizzo()!= null){
            societa.setIndirizzo(societaDTO.getIndirizzo());
        }

        return new ResponseEntity<>(societaService.update(societa), HttpStatus.OK);
    }
}
