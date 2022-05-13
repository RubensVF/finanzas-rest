package com.ruben.finanzas.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ruben.finanzas.models.Gastos;
import com.ruben.finanzas.services.GastosService;
import com.ruben.finanzas.utils.PdfReports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/gastos")
public class GastosController {

    @Autowired
    private GastosService gService;


    @GetMapping("/")
    public List<Gastos> gastos(){
        return gService.getGastos();
    }

    @GetMapping("/comunes")
    public List<String> comunes(){
        return gService.getConceptosComunes();
    }
    @PostMapping("/")
    public Gastos save(Gastos gastos){
        return gService.guardar(gastos);
    }



    @RequestMapping(value = "/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<Gastos> gastos = gService.getGastosDeLaSemana();

        ByteArrayInputStream bis = PdfReports.citiesReport(gastos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
