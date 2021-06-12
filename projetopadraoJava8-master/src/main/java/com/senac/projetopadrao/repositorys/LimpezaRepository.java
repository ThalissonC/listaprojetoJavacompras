package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Limpeza;
import com.senac.projetopadrao.models.Limpeza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimpezaRepository extends JpaRepository<Limpeza, Long> {

}
