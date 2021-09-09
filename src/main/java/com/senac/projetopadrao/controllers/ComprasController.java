package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Compra;
import com.senac.projetopadrao.repositorys.ItemCompradoRepository;
import com.senac.projetopadrao.repositorys.CompraRepository;
import com.senac.projetopadrao.services.ItemCompradoService;
import com.senac.projetopadrao.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller




public class ComprasController {

//    @RequestMapping("/")
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }

    @Autowired
    CompraRepository compraRepository;
    ItemCompradoRepository itemCompradoRepository;
    CompraService compraService;
    ItemCompradoService itemCompradoService;



    @RequestMapping("/")
    public ModelAndView listaAlimentos() {
        ModelAndView mv = new ModelAndView("index");

        ArrayList<Compra> index = new ArrayList<>();

        index = (ArrayList<Compra>) compraRepository.findAll();

        mv.addObject("index", index);

        return mv;
    }


    @RequestMapping("/addNew")
    public String addNew(Compra compra){
        compraRepository.save(compra);
        return "redirect:/";

    }

    /*
    @GetMapping("/{id}")
    public String editarAlimentoModel(@PathVariable(value = "id") Long id){
        Alimento alimento = alimentoRepository.findAlimentoById(id);
        return "alimentos";
    }
    */

    /*
        @PostMapping("/{id}")
        public String editarAlimento(@PathVariable(value = "id") Long id, Alimento alimento){
            alimento.setId(id);
            alimentoRepository.save(alimento);
            return "redirect:/alimentos/";
        }
    */
    @GetMapping("/getOne")
    @ResponseBody
    public String getOne(Long id){
        return compraService.getOne(id).getNome();

    }

    @PostMapping("/delete")

    public void DeleteOne(Long id){
        compraService.getOne(id).getNome();
        compraRepository.deleteById(id);

    }

    @RequestMapping("/update")
    public String update(Compra compra){
        compraService.update(compra);
        return "redirect:/index/";
    }

//    @GetMapping("/deletar/{id}")
//    public String deletar(@PathVariable(value = "id") Long id){
//
//        Alimento alimento = alimentoRepository.findAlimentoById(id);
//
//        alimentoRepository.delete(alimento);
//        //(id=${alimento.id})
//        return "redirect:/";
//    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){

        Compra compra = compraRepository.findAlimentoById(id);
        compraRepository.delete(compra);

        return "redirect:/";
    }

}
