package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Higiene;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import com.senac.projetopadrao.repositorys.HigieneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller



@RequestMapping("/higienes")
public class HigieneController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    HigieneRepository higieneRepository;

    @GetMapping("/")
        public ModelAndView listaHigienes() {
            ModelAndView mv = new ModelAndView("higienes");

            ArrayList<Higiene> higienes = new ArrayList<>();

            higienes = (ArrayList<Higiene>) higieneRepository.findAll();

            mv.addObject("higienes", higienes);

            return mv;
        }

    @GetMapping("/add")
        public String addHigienePage(Higiene higiene) {
        return "higienes_add";
    }

    @PostMapping("/add")
        public String addHigiene (@Validated Higiene higiene){
        higieneRepository.save(higiene);

        return "redirect:/higienes/";
    }

}

