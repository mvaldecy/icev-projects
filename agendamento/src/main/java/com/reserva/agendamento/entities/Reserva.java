package com.reserva.agendamento.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String cpfHospede;
    private String nomeHospede;
    private String email;
    private String telefone;
    private String acompanhante;
    private Boolean alergia;
    private String tipoAlergia;

    public Reserva(LocalDate startDate, LocalDate endDate, String cpfHospede, String nomeHospede, String email,
            String telefone, String acompanhante, Boolean alergia, String tipoAlergia) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.cpfHospede = cpfHospede;
        this.nomeHospede = nomeHospede;
        this.email = email;
        this.telefone = telefone;
        this.acompanhante = acompanhante;
        this.alergia = alergia;
        this.tipoAlergia = tipoAlergia;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getCpfHospede() {
        return cpfHospede;
    }
    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }
    public String getNomeHospede() {
        return nomeHospede;
    }
    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getAcompanhante() {
        return acompanhante;
    }
    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }
    public Boolean getAlergia() {
        return alergia;
    }
    public void setAlergia(Boolean alergia) {
        this.alergia = alergia;
    }
    public String getTipoAlergia() {
        return tipoAlergia;
    }
    public void setTipoAlergia(String tipoAlergia) {
        this.tipoAlergia = tipoAlergia;
    }

    

    
    
}
