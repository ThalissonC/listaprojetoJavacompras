package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Satelite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SateliteRepository extends JpaRepository<Satelite, Long> {

}