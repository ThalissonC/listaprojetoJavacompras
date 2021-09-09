package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Compra;
import com.senac.projetopadrao.models.ItemComprado;
import com.senac.projetopadrao.repositorys.ItemCompradoRepository;
import com.senac.projetopadrao.repositorys.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@RestController
@RequestMapping({"/api/alimentos/comprados"})

public class ApiCompradosController {

@Autowired
CompraRepository compraRepository;
ItemCompradoRepository itemCompradoRepository;

    ApiCompradosController(ItemCompradoRepository itemCompradoRepository){
        this.itemCompradoRepository = itemCompradoRepository;
    }

    @GetMapping
    public ArrayList<ItemComprado> findAll() {
        return (ArrayList<ItemComprado>) itemCompradoRepository.findAll();
    }


    // Adiciona Dados
    @PostMapping("/add")
    public ItemComprado create(@RequestBody ItemComprado itemComprado){
        return itemCompradoRepository.save(itemComprado);
    }

    // Recebe Dados
    @GetMapping(path = {"/alimento/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
       return itemCompradoRepository.findById(id)
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build());
    }

    // Edição
    @PutMapping(value="/alimento/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody Compra compra) {
        return compraRepository.findById(id)
                .map(record -> {
                    record.setId(compra.getId());
                    record.setNome(compra.getNome());
                    record.setCategoria(compra.getCategoria());
                    record.setQuantidade(compra.getQuantidade());
                    record.setValorUnitario(compra.getValorUnitario());
                    record.setData(compra.getData());


                    Compra updated  = compraRepository.save(record);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

//    // Edição AlimentoComprado
//    @PutMapping(value="/alimentoComprado/{id}")
//    public ResponseEntity updateAlimentoComprado(@PathVariable("id") Long id,
//                                 @RequestBody Alimento alimento) {
//        return alimentoRepository.findById(id)
//                .map(record -> {
//                    record.setId(alimento.getId());
//                    record.setComprado(alimento.getComprado());
//
//                    Alimento updated  = alimentoRepository.save(record);
//
//                    return ResponseEntity.ok().body(updated);
//                }).orElse(ResponseEntity.notFound().build());
//    }

    // Delete
//    @DeleteMapping(path ={"/deletarAlimento/{id}"})
//    public ResponseEntity <?> delete(@PathVariable Long id) {
//        return alimentoRepository.findById(id)
//                .map(record -> {
//                    alimentoRepository.deleteById(id);
//                    return ResponseEntity.ok().build();
//                }).orElse(ResponseEntity.notFound().build());
//    }

    // Delete
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){

        Compra compra = compraRepository.findAlimentoById(id);
        compraRepository.delete(compra);

        //(id=${alimento.id})
        return "redirect:/";
    }

    // Delete
    @GetMapping("/deletarComprado/{id}")
    public RedirectView deletarItemComprado(@PathVariable(value = "id") Long id){

        ItemComprado itemComprado = itemCompradoRepository.findAlimentoCompradoById(id);
        itemCompradoRepository.delete(itemComprado);

        //(id=${alimento.id})
        return new RedirectView("/itensComprados");
    }

}



