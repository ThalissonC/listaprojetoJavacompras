package com.senac.projetopadrao.services;

import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    

}
