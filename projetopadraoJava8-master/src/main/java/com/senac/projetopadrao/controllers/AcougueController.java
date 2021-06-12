package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Acougue;
import com.senac.projetopadrao.models.Acougue;
import com.senac.projetopadrao.models.Acougue;
import com.senac.projetopadrao.repositorys.AcougueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller



@RequestMapping("/acougues")
public class AcougueController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @Autowired
    AcougueRepository acougueRepository;

    @GetMapping("/")
        public ModelAndView listaAçougue() {
            ModelAndView mv = new ModelAndView("acougues");

            ArrayList<Acougue> acougues = new ArrayList<>();

            acougues = (ArrayList<Acougue>) acougueRepository.findAll();

            mv.addObject("acougues",acougues);

            return mv;
        }

    @GetMapping("/add")
    public String addAcougePage(Acougue acougue) {
        return "acougues_add";
    }

    @PostMapping("/add")
    public String addAcougue (@Validated Acougue acougue){
        acougueRepository.save(acougue);

        return "redirect:/acougues/";
    }
    }

