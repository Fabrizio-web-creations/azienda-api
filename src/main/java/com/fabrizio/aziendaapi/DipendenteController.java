package com.fabrizio.aziendaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteRepository repository;

    @GetMapping
    public List<Dipendente> getAll() {
        return repository.findAll();
    }
    @GetMapping("/ruolo/{ruolo}")
    public List<Dipendente> getByRuolo(@PathVariable String ruolo) {
        return repository.findByRuolo(ruolo);
    }

    @GetMapping("/nome/{nome}")
    public List<Dipendente> getByNome(@PathVariable String nome) {
        return repository.findByNome(nome);
    }

    @GetMapping("/conta/{ruolo}")
    public long contaPerRuolo(@PathVariable String ruolo) {
        return repository.countByRuolo(ruolo);
    }

    @GetMapping("/stipendio/{soglia}")
    public List<Dipendente> getByStipendioMaggioreDi(@PathVariable double soglia) {
        return repository.findByStipendioGreaterThan(soglia);
    }

    @PostMapping
    public Dipendente create(@RequestBody Dipendente dipendente) {
        return repository.save(dipendente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Dipendente update(@PathVariable Long id, @RequestBody Dipendente nuovo) {
        nuovo.setId(id);
        return repository.save(nuovo);
    }
    @PutMapping("/{id}/aumento")
    public Dipendente aumentaStipendio(@PathVariable Long id, @RequestParam double importo) {
        Dipendente dipendente = repository.findById(id).get();
        dipendente.setStipendio(dipendente.getStipendio() + importo);
        return repository.save(dipendente);
    }
    @GetMapping("/media-stipendio")
    public double mediaStipendio() {
        List<Dipendente> dipendenti = repository.findAll();

        double somma = 0;
        for (Dipendente d : dipendenti) {
            somma = somma + d.getStipendio();
        }

        double media = somma / dipendenti.size();
        return media;
    }
}