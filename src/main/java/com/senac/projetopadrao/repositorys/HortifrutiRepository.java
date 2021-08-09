package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.models.Hortifruti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HortifrutiRepository extends JpaRepository<Hortifruti, Long> {

}
