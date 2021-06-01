package com.senac.projetopadrao.repositorys;

import com.senac.projetopadrao.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
