package com.senac.projetopadrao.repositorys;

import java.util.List;
import java.util.Optional;
import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {

    Alimento findAlimentoById(Integer id);
    List<Alimento> findAlimentoByNome(String nome);



}
