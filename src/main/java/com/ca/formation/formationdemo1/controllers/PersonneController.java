package com.ca.formation.formationdemo1.controllers;

import com.ca.formation.formationdemo1.dto.PersonneDTO;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonneController {

    private  final PersonneRepository repository;
    private static final String INDEX="index";
    private static final String PERSONNES="personnes";

    private static final String NOUVEAU="nouveau";

    private static final String REDIRECT="redirect:/";

    public PersonneController(PersonneRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getPersonnes(Model model){
        model.addAttribute(PERSONNES, repository.findAll());
        return INDEX;
    }

    @GetMapping("/nouveau")
    public String nouveauPersonne(PersonneDTO personne){
        return NOUVEAU;
    }

    @PostMapping("/ajouterPersonne")
    public String ajouterPersonne(PersonneDTO personne, Model model){
        Personne personne1=new Personne();
        repository.save(personne1);
        return REDIRECT;


    }



}
