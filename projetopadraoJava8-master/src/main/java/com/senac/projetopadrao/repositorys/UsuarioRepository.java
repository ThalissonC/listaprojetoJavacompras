package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioById(Long id);
    List<Usuario> findUsuarioByNome(String nome);
}
