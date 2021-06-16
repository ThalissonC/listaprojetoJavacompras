package com.senac.projetopadrao.services;

import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.senac.projetopadrao.models.Alimento;
import com.senac.projetopadrao.repositorys.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public Optional<Alimento> getOne(Integer id) {
        return Optional.ofNullable(alimentoRepository.findAlimentoById(id));
    }

    public void update(Alimento alimento) {
        alimentoRepository.save(alimento);
    }


}