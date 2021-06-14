package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findPessoaByid (Long id);
}
