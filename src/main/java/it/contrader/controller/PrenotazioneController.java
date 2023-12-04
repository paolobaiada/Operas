package it.contrader.controller;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazione")
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController extends AbstractController<PrenotazioneDTO> {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping(value ="/prenota")
    public ResponseEntity<PrenotazioneDTO> prenota(@RequestBody PrenotazioneDTO prenotazioneDTO){
        return new ResponseEntity<>(prenotazioneService.insert(prenotazioneDTO), HttpStatus.OK);
    }

    @GetMapping(value ="/storico/{idAnagrafica}")
    public List<PrenotazioneDTO> getStorico(@PathVariable Long idAnagrafica){
        List<PrenotazioneDTO> prenotazioni = (List<PrenotazioneDTO>) prenotazioneService.getStorico(idAnagrafica);
        return prenotazioni;
    }

    @GetMapping(value ="/dettaglio/{idPrenotazione}")
    public PrenotazioneDTO getDettaglio(@PathVariable Long idPrenotazione){
        PrenotazioneDTO prenotazioneDTO = prenotazioneService.read(idPrenotazione);
        return prenotazioneDTO;
    }
}
