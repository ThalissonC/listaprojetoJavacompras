package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller



@RequestMapping("/alimentos")
public class AlimentoController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    AlimentoRepository alimentoRepository;

    @GetMapping("/")
        public ModelAndView listaAlimentos() {
            ModelAndView mv = new ModelAndView("alimentos");

            ArrayList<Alimento> alimentos = new ArrayList<>();

            alimentos = (ArrayList<Alimento>) alimentoRepository.findAll();

            mv.addObject("alimentos", alimentos);

            return mv;
        }

  // @GetMapping("/add")
    //    public String addAlimentoPage(Alimento alimento) {
    //   return "alimentos";
   // }

    @PostMapping("/")
        public String addAlimento (@Validated Alimento alimento){
        alimentoRepository.save(alimento);

        return "redirect:/alimentos/";
    }

}

