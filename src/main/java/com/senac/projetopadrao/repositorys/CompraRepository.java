package com.senac.projetopadrao.repositorys;

import java.util.List;

import com.senac.projetopadrao.models.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {



    Compra findAlimentoById(Long id);
    List<Compra> findAlimentoByNome(String nome);



}
