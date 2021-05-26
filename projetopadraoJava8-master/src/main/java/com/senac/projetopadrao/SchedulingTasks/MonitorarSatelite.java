package com.senac.projetopadrao.SchedulingTasks;

import com.senac.projetopadrao.models.Clima;
import com.senac.projetopadrao.models.Satelite;
import com.senac.projetopadrao.repositorys.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MonitorarSatelite {

    //Json convert
    //Json para java online

    @Autowired
    SateliteRepository sateliteRepository;

    @Scheduled(fixedRate = 5000)
    public void verificarSatelite(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        Satelite satelite =  restTemplate.getForObject(
                "https://api.wheretheiss.at/v1/satellites/25544",
                Satelite.class);

        sateliteRepository.save(satelite);

    }

}