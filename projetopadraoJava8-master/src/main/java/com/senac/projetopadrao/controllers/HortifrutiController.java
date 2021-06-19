package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Hortifruti;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import com.senac.projetopadrao.repositorys.HortifrutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller



@RequestMapping("/hortifrutis")
public class HortifrutiController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    HortifrutiRepository hortifrutiRepository;

    @GetMapping("/")
        public ModelAndView listaAlimentos() {
            ModelAndView mv = new ModelAndView("hortifrutis");

            ArrayList<Hortifruti> hortifrutis = new ArrayList<>();

            hortifrutis = (ArrayList<Hortifruti>) hortifrutiRepository.findAll();

            mv.addObject("hortifrutis", hortifrutis);

            return mv;
        }

    @GetMapping("/add")
        public String addHortifrutiPage(Hortifruti hortifruti) {
        return "hortifrutis_add";
    }

    @PostMapping("/add")
        public String addHortifruti (@Validated Hortifruti hortifruti){
        hortifrutiRepository.save(hortifruti);

        return "redirect:/hortifrutis/";
    }

}

