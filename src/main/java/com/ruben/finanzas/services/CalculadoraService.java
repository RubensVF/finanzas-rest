package com.ruben.finanzas.services;

import java.util.List;

import com.ruben.finanzas.models.Gastos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    
    @Autowired
    private GastosService gService;

    public float total(){

        List<Gastos> gastos = gService.getGastosDeLaSemana();

        float total = 0f;
        for (Gastos gasto : gastos) {
            total+=gasto.getMonto();
        }
        return total;
    }
}
