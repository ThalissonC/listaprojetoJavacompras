package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
