package com.senac.projetopadrao.services;

import com.senac.projetopadrao.models.Compra;
import com.senac.projetopadrao.repositorys.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra getOne(Long id) {
        return compraRepository.findAlimentoById(id);
    }


    public void update(Compra compra) {

        compraRepository.save(compra);
    }


}