package com.ruben.finanzas.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
}
