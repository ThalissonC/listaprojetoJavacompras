//package com.senac.projetopadrao.controllers;
//
//import com.senac.projetopadrao.models.Alimento;
//import com.senac.projetopadrao.repositorys.AlimentoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//
//@Controller
//
//
//
//public class HomeController {
//
//    @Autowired
//    AlimentoRepository alimentoRepository;
//
//    @RequestMapping("/")
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }
//
////    @RequestMapping("/alimentos")
////    public ModelAndView alimentos(){
////        return new ModelAndView("alimentos");
////    }
////
////    @GettMapping("/alimentos")
////    public ModelAndView listaAlimentos() {
////        ModelAndView mv = new ModelAndView("alimentos");
////
////        ArrayList<Alimento> alimentos = new ArrayList<>();
////
////        alimentos = (ArrayList<Alimento>) alimentoRepository.findAll();
////
////        mv.addObject("alimentos", alimentos);
////
////        return mv;
////    }
////
////    @GetMapping("/add")
////    public String addAlimentoPage(Alimento alimento) {
////        return "alimentos_add";
////    }
//}
//
