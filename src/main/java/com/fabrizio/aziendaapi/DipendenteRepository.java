package com.fabrizio.aziendaapi;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

    List<Dipendente> findByRuolo(String ruolo);

    List<Dipendente> findByStipendioGreaterThan(double stipendio);

    List<Dipendente> findByNome(String nome);
    Long countByRuolo(String numero);
}