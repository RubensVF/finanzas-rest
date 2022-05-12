package com.ruben.finanzas.repositories;

import java.util.Date;
import java.util.List;

import com.ruben.finanzas.models.Gastos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosRepository extends JpaRepository<Gastos,Long>{
    
    List<Gastos> findByFechaBetween(Date fechaInicial,Date fechaFinal);
}
