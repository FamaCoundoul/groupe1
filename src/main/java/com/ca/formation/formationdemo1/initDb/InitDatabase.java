package com.ca.formation.formationdemo1.initDb;

import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.models.Utilisateur;
import com.ca.formation.formationdemo1.services.UtilisateurService;
import org.apache.logging.log4j.Level;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Logger;


@Component
public class InitDatabase implements ApplicationListener<ApplicationReadyEvent> {

  private UtilisateurService utilisateurService;

  public InitDatabase(UtilisateurService utilisateurService) {
    this.utilisateurService = utilisateurService;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    try {
      // creer utilisateur
      utilisateurService
          .registration(new Utilisateur("michel@formation.sn", "Passer@123", "Michel", Set.of(new Role(Role.READ))));
      utilisateurService
          .registration(new Utilisateur("clara@formation.sn", "Passer@123", "Clara", Set.of(new Role(Role.ADMIN))));
    } catch (Exception e) {
      Logger.getLogger(e.getMessage());
    }
  }
}
