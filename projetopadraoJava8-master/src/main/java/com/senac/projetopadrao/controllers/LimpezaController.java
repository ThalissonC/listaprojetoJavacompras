package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Limpeza;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import com.senac.projetopadrao.repositorys.LimpezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller



@RequestMapping("/limpezas")
public class LimpezaController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    LimpezaRepository limpezaRepository;

    @GetMapping("/")
        public ModelAndView listaLimpeza() {
            ModelAndView mv = new ModelAndView("limpezas");

            ArrayList<Limpeza> limpezas = new ArrayList<>();

            limpezas = (ArrayList<Limpeza>) limpezaRepository.findAll();

            mv.addObject("limpezas", limpezas);

            return mv;
        }

    @GetMapping("/add")
        public String addAlimentoPage(Alimento alimento) {
        return "alimentos_add";
    }

    @PostMapping("/add")
        public String addLimpeza (@Validated Limpeza limpeza){
        limpezaRepository.save(limpeza);

        return "redirect:/limpeza/";
    }

}

