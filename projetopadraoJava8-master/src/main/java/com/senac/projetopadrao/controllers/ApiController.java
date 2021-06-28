package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @PutMapping(value="/alimento/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody Alimento alimento) {
        return alimentoRepository.findById(id)
                .map(record -> {
                    record.setId(alimento.getId());
                    record.setNome(alimento.getNome());
                    record.setQuantidade(alimento.getQuantidade());
                    record.setValorUnitario(alimento.getValorUnitario());
                    record.setData(alimento.getData());


                    Alimento updated  = alimentoRepository.save(record);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/alimento/{id}"})
    public ResponseEntity <?> delete(@PathVariable Long id) {
        return alimentoRepository.findById(id)
                .map(record -> {
                    alimentoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}



