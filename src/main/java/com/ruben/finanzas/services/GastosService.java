package com.ruben.finanzas.services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.ruben.finanzas.models.Gastos;
import com.ruben.finanzas.repositories.GastosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastosService {
    
    @Autowired
    private GastosRepository gRepository;

    public List<Gastos> getGastos(){
        return gRepository.findAll();
    }

    public Gastos guardar(Gastos gasto){
        return gRepository.save(gasto);
    }

    public List<Gastos> getGastosDeLaSemana(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
        calendar.add(Calendar.DATE, -i);
        Date start = calendar.getTime();
        calendar.add(Calendar.DATE, 6);
        Date end = calendar.getTime();
        return gRepository.findByFechaBetween(start,end);
    }


    public static float totalGastos(List<Gastos> gastos){ 
        float total = 0f;
        for (Gastos gasto : gastos) {
            total+=gasto.getMonto();
        }
        return total;
    }

    public List<String> getConceptosComunes(){
        
        Set<String> conceptos = new HashSet<>();

        List<Gastos> gastos = getGastos();

        for (Gastos gasto : gastos) {
            conceptos.add(gasto.getConcepto());
        }

        return conceptos.stream().collect(Collectors.toList());
    }
}
