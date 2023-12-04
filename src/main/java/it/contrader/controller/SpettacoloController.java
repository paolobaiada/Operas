package it.contrader.controller;
import it.contrader.dto.SpettacoloDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Spettacolo;
import it.contrader.service.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/spettacolo")
@CrossOrigin(origins = "http://localhost:4200")
public class SpettacoloController extends AbstractController<SpettacoloDTO> {

    @Autowired
    SpettacoloService spettacoloService;

    @GetMapping(value = "/getSpettacoli")
    public List<SpettacoloDTO> getAll(){

        List<SpettacoloDTO> spettacoli = (List<SpettacoloDTO>) spettacoloService.getAll();

        // Non è necessario alcun riferimento a spettacolo.getImmagine() o alla conversione in Base64

        return spettacoli;
    }
    @GetMapping(value = "/readspettacoli/{idSocieta}")
    public List<SpettacoloDTO> findSocietaIdSocieta(@PathVariable Long idSocieta){
        return (List<SpettacoloDTO>) spettacoloService.findBySocietaIdSocieta(idSocieta);
    }
    @PostMapping(value = "/insertspettacolo")
    public ResponseEntity<SpettacoloDTO> insertSpettacolo(@RequestBody SpettacoloDTO spettacolo){
        return new ResponseEntity<>(spettacoloService.insert(spettacolo), HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletespettacolo")
    public ResponseEntity<Void> deleteSpettacolo(@RequestParam("idSpettacolo") Long id){
         spettacoloService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/updatespettacolo/{id}")
    public ResponseEntity<SpettacoloDTO> updateSpettacolo(@PathVariable Long id, @RequestBody @Valid SpettacoloDTO spettacoloDTO){
       SpettacoloDTO spettacolo = spettacoloService.read(id);


            spettacolo.setCodiceProdotto(spettacoloDTO.getCodiceProdotto());

            spettacolo.setDescrizione(spettacoloDTO.getDescrizione());

            spettacolo.setCosto(spettacoloDTO.getCosto());

            spettacolo.setImmagine(spettacoloDTO.getImmagine());

            spettacolo.setOrario(spettacoloDTO.getOrario());

            spettacolo.setNomeProdotto(spettacoloDTO.getNomeProdotto());

            spettacolo.setTipologia(spettacoloDTO.getTipologia());

        return new ResponseEntity<>(spettacoloService.update(spettacolo),HttpStatus.OK);
    }

   @GetMapping(value = "/getData")
        public HashMap<Date,Integer> getData(@RequestParam("id") Long id){
            return spettacoloService.getStats(id);
       }


    @GetMapping(value = "/getDettaglio/{idSpettacolo}")
    public SpettacoloDTO getDettaglio(@PathVariable Long idSpettacolo){
        SpettacoloDTO spettacolo = (SpettacoloDTO) spettacoloService.read(idSpettacolo);

        // Non è necessario alcun riferimento a spettacolo.getImmagine() o alla conversione in Base64

        return spettacolo;
    }
}
