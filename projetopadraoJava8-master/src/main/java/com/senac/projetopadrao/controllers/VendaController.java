package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.models.Venda;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import com.senac.projetopadrao.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("/")
        public ModelAndView listaVendas() {
            ModelAndView mv = new ModelAndView("vendas");

            List<Venda> vendas = new ArrayList<>();

            vendas = vendaRepository.findAll();

            mv.addObject("vendas", vendas);

            return mv;
        }

    @GetMapping("/add")
        public String addVendaPage(Venda venda) {
        return "vendas_add";
    }

    @PostMapping("/add")
        public String addVenda (@Validated Venda venda){
        vendaRepository.save(venda);

        return "redirect:/vendas/";
    }

}
