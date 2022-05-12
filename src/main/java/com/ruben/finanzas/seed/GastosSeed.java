package com.ruben.finanzas.seed;


import com.ruben.finanzas.models.Gastos;
import com.ruben.finanzas.repositories.GastosRepository;
import com.ruben.finanzas.services.CalculadoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GastosSeed implements ApplicationRunner{

    @Autowired
    private GastosRepository gfRepository;

    @Autowired 
    private CalculadoraService cService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Gastos gastos = new Gastos("Bascula", 300.0f);
        gastos = gfRepository.save(gastos);

        System.out.println(cService.total());
        
    }
    


}
