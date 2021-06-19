package com.senac.projetopadrao.controllers;


import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public ModelAndView listaUsuarios() {
        ModelAndView mv = new ModelAndView("usuarios");

        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();

        mv.addObject("usuarios", usuarios);

        return mv;
    }

    @GetMapping("/add")
    /*public ModelAndView addUsuarioPage(){
        ModelAndView movelAndView = new ModelAndView("usuarios_add")
        Usuario usuario = new Usuario();
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
}
    */
        public String addUsuarioPage(Usuario usuario){
        return "usuarios_add";
    }

    @PostMapping("/add")
        public String addUsuario(@Validated Usuario usuario){
            usuarioRepository.save(usuario);

            return "redirect:/usuarios/";
    }

    @GetMapping("/{id}")
    public ModelAndView editarUsuarioPage(@PathVariable(value = "id") Long id){

            Usuario usuario = usuarioRepository.findUsuarioById(id);

        ModelAndView modelAndView = new ModelAndView("usuarios_edit");
        modelAndView.addObject("usuario",usuario);

        return modelAndView;
    }

    @PostMapping("/{id}")
    public String editarUsuario(@PathVariable(value = "id") Long id, Usuario usuario){

        usuario.setId(id);


        usuarioRepository.save(usuario);
        return "redirect:/usuarios/";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        usuarioRepository.delete(usuario);

        return "redirect:/usuarios/";
    }

}

