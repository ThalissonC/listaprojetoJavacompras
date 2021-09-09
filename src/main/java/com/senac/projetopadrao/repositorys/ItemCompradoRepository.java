package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.ItemComprado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompradoRepository extends CrudRepository<ItemComprado, Long> {

    ItemComprado findAlimentoCompradoById(Long id);
//    List<Alimento> findAlimentoByNome(String nome);
//    List<AlimentoComprado> findAlimentoComprado(String nome, int quantidade, double ValorUnitario);



}
