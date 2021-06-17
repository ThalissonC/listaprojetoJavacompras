package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/api/alimentos"})

public class ApiController {

@Autowired
AlimentoRepository alimentoRepository;

    ApiController(AlimentoRepository alimentoRepository){
        this.alimentoRepository = alimentoRepository;
    }

    @GetMapping
    public ArrayList<Alimento> findAll() {
        return (ArrayList<Alimento>) alimentoRepository.findAll();
    }

    @GetMapping(path = {"/alimento/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
       return alimentoRepository.findById(id)
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build());
    }



}
