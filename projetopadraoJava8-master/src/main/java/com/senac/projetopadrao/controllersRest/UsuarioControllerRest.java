package com.senac.projetopadrao.controllersRest;

import com.senac.projetopadrao.models.Usuario;


import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerRest {

    @Autowired
    UsuarioRepository usuarioRepository;



    @PostMapping("/add")
    public String addUsuario(){

        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuarioRepository.save(usuario);

        return "usuario adicionado";
    }
}
*/