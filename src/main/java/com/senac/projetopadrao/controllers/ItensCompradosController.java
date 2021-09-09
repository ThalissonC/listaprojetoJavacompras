package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.ItemComprado;
import com.senac.projetopadrao.repositorys.ItemCompradoRepository;
import com.senac.projetopadrao.services.CompraService;
import com.senac.projetopadrao.services.ItemCompradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller




public class ItensCompradosController {

//    @RequestMapping("/")
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }

    @Autowired
    ItemCompradoRepository itemCompradoRepository;
    CompraService compraService;
    ItemCompradoService itemCompradoService;

        @RequestMapping("/itensComprados")
        public ModelAndView listaAlimentosComprados() {
            ModelAndView mv = new ModelAndView("itensJaComprados");

            ArrayList<ItemComprado> listaCompradoIndex = new ArrayList<>();

            listaCompradoIndex = (ArrayList<ItemComprado>) itemCompradoRepository.findAll();

            mv.addObject("itensJaComprados", listaCompradoIndex);

            return mv;
        }

        @GetMapping("/getOneItemComprado")
        @ResponseBody
        public String getOneItemComprado(Long id){
            return itemCompradoService.getOne(id).getNomeItemComprado();

        }

//    @RequestMapping("/addNew")
//    public String addNew(Alimento alimento){
//        alimentoRepository.save(alimento);
//        return "redirect:/";
//
//    }

//    @GetMapping("/deletarItemComprado/{id}")
//    public String deletarItemComprado(@PathVariable(value = "id") Long id){
//
//        AlimentoComprado alimentoComprado = alimentoCompradoRepository.findAlimentoCompradoById(id);
//
//        alimentoCompradoRepository.delete(alimentoComprado);
//        //(id=${alimento.id})
//        return "redirect:/";
//    }

}

