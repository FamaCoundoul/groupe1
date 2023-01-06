package com.ca.formation.formationdemo1.services;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableAsync
public class SchedulePersonneExportService {

    private SchedulePersonneExportService() {
    }

    //@Async
    //@Scheduled(fixedDelay = 10000)
    public static void envoyerListePersonnes(){

        Logger.getLogger(" Envoyer la liste des personne - "+System.currentTimeMillis()/1000);
    }
}
