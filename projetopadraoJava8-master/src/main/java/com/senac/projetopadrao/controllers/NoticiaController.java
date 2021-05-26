package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Noticia;
import com.senac.projetopadrao.models.Produto;
import com.senac.projetopadrao.repositorys.NoticiaRepository;
import com.senac.projetopadrao.repositorys.ProdutoRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

//@Controller mostra para o Spring que esta classe é um controlador
//e que ele também é uma página

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    NoticiaRepository noticiaRepository;

    @GetMapping("/")
    public ModelAndView listaNoticias() {
        ModelAndView mv = new ModelAndView("noticias");

        ArrayList<Noticia> noticias = new ArrayList<Noticia>();

        noticias = (ArrayList<Noticia>) noticiaRepository.findAll();

        mv.addObject("noticias", noticias);

        return mv;
    }

    @GetMapping("/add")
    public String addNoticiaPage(Noticia noticia){

        return "noticias_add";
    }

    @PostMapping("/add")
    public String addNoticia(@Validated Noticia noticia){
        noticiaRepository.save(noticia);

        return "redirect:/noticias/";
    }

}
