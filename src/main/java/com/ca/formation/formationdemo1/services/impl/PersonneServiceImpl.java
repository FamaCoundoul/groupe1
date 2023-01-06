package com.ca.formation.formationdemo1.services.impl;


import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import com.ca.formation.formationdemo1.services.PersonneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public List<Personne> getPersonnes() {
        return (List) personneRepository.findAll();
    }

    @Override
    public Personne getPersonne(Long id) throws ResourceNotFoundException {
        return personneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personne non trouvé "));
    }

    @Override
    public Personne updatePersonne(Long id, Personne personneRequest) throws ResourceNotFoundException  {
        Optional<Personne> optionalPersonne = personneRepository.findById(id);
        if(optionalPersonne.isEmpty()){
            throw new ResourceNotFoundException("Mise à jour impossible ");
        }
        Personne personne = optionalPersonne.get();

        Long optionalPersonneId=optionalPersonne.get().getId();
        Long personneId=personne.getId();
        boolean perstrue=personneId.equals(optionalPersonneId);
        if(optionalPersonneId==null && !perstrue){

            throw new ResourceNotFoundException("l'Id n'existe pas");
        }
        personne.setAge(personneRequest.getAge());
        personne.setNom(personneRequest.getNom());
        personne.setPrenom(personneRequest.getPrenom());
        return personneRepository.save(personne);
    }

    @Override
    public Personne addPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public void deletePersonne(Long id) {
            personneRepository.deleteById(id);
    }

    @Override
    public List<Personne> getPersonneParNom(String nom) {
        return personneRepository.findByNom(nom);
    }

}
