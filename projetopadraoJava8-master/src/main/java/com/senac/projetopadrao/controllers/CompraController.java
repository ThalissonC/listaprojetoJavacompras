package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Compra;
import com.senac.projetopadrao.models.Venda;
import com.senac.projetopadrao.repositorys.CompraRepository;
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
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraRepository compraRepository;

    @GetMapping("/")
        public ModelAndView listaCompras() {
            ModelAndView mv = new ModelAndView("compras");

            ArrayList<Compra> compras = new ArrayList<>();

            compras = (ArrayList<Compra>) compraRepository.findAll();

            mv.addObject("compras", compras);

            return mv;
        }

    @GetMapping("/add")
        public String addCompraPage(Compra compra) {
        return "compras_add";
    }

    @PostMapping("/add")
        public String addCompra (@Validated Compra compra){
        compraRepository.save(compra);

        return "redirect:/compras/";
    }

}
