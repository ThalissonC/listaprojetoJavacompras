package com.senac.projetopadrao.services;

import com.senac.projetopadrao.models.ItemComprado;
import com.senac.projetopadrao.repositorys.ItemCompradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCompradoService {

    @Autowired
    private ItemCompradoRepository itemCompradoRepository;

    public ItemComprado getOne(Long id) {
        return itemCompradoRepository.findAlimentoCompradoById(id);
    }


    public void update(ItemComprado itemComprado) {

        itemCompradoRepository.save(itemComprado);
    }


}