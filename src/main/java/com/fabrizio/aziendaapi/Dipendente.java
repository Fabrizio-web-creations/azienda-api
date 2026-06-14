package com.fabrizio.aziendaapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ruolo;
    private double stipendio;

    public Dipendente() {}

    public Dipendente(String nome, String ruolo, double stipendio) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.stipendio = stipendio;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getRuolo() { return ruolo; }
    public double getStipendio() { return stipendio; }

    public void setNome(String nome) { this.nome = nome; }
    public void setRuolo(String ruolo) { this.ruolo = ruolo; }
    public void setStipendio(double stipendio) { this.stipendio = stipendio; }

    public void setId(Long id) {
        this.id = id;
    }
}