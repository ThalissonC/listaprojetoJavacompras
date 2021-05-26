package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Noticia;
import com.senac.projetopadrao.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
