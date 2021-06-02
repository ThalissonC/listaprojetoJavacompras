package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Compra;
import com.senac.projetopadrao.repositorys.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}

