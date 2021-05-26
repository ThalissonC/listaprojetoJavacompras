package com.senac.projetopadrao.SchedulingTasks;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    /*
    @Scheduled(fixedRate = 5000)
    public void checkClima() {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        Clima[] climas =
                restTemplate.getForObject(
                        "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=a900609c17e775626610716ef9d8fd73",
                        Clima[].class);
        if(climas!=null){
            for (Clima clima : climas){
                Clima climaBanco = climaRepository.findByDate(clima.getDate());
                if(climaBanco != null){
                    if(!climaBanco.getText().equals(clima.getText())){
                        climaRepository.save(clima);
                    }
                }else {
                    climaRepository.save(clima);
                }
            }
        }
    }
 */
}

