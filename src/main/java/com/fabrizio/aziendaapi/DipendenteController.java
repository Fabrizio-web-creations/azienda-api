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
}