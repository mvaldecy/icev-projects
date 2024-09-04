package com.reserva.agendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserva.agendamento.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
