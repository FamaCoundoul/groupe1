
package com.ca.formation.formationdemo1.services;

import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import com.ca.formation.formationdemo1.services.impl.PersonneServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonneServiceImplTest {
    @Mock
    PersonneRepository personneRepository;

    @InjectMocks
    private PersonneServiceImpl personneServiceImpl;

    @Test
    public void ajouterPersonne() {
        Personne personne = new Personne("tonux", "samb", 50);
        personne.setId(1L);
        when(personneRepository.save(any())).thenReturn(personne);

        Personne personneResponse = personneServiceImpl.addPersonne(new Personne("tonux", "samb", 50));

        assertNotNull(personneResponse);

        verify(personneRepository, atLeastOnce()).save(any());
    }

    // TODO: ajouter les autres tests sur methodes Fait

    @Test
    public void getListPersonnes() {
        Personne personne1 = new Personne("nom1", "prenom1", 20);
        Personne personne2 = new Personne("nom2", "prenom2", 30);
        List<Personne> personnes = Arrays.asList(personne1, personne2);
        when(personneRepository.findAll()).thenReturn(personnes);

        List<Personne> result = personneServiceImpl.getPersonnes();

        assertEquals(2, result.size());
    }

    @Test
    public void getPersonne() throws ResourceNotFoundException {
        Long id = 1L;
        Personne personne = new Personne("nom", "prenom", 20);
        when(personneRepository.findById(id)).thenReturn(Optional.of(personne));

        Personne personne1 = personneServiceImpl.getPersonne(id);

        org.junit.Assert.assertEquals(personne, personne1);

    }

    @Test
    public void updatePersonne() throws ResourceNotFoundException {

        Personne personneRequest = new Personne("yes", "yes", 20);
        personneRequest.setId(1L);
        when(personneRepository.findById(1L)).thenReturn(Optional.of(personneRequest));
        when(personneRepository.save(personneRequest)).thenReturn(personneRequest);
        personneServiceImpl.updatePersonne(1L, personneRequest);
    }


    @Test
    public void deletePersonne() throws ResourceNotFoundException {
        Personne personne = new Personne("nom5", "prenom5", 20);
        personneRepository.save(personne);
        //personne.setId(1L);
        when(personneRepository.findById(personne.getId())).thenReturn(Optional.of(personne));
        personneServiceImpl.deletePersonne(personne.getId());
        assertThat(personneServiceImpl.getPersonne(personne.getId()));

    }

    @Test
    public void getPersonneParNom() {
        String nom = "nom";
        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("nom", "prenom", 20));
        when(personneRepository.findByNom(nom)).thenReturn(personnes);
        List<Personne> personnes1 = personneServiceImpl.getPersonneParNom(nom);
        assertThat(personnes1).isNotNull();
        org.junit.Assert.assertEquals(1,personnes1.size());
    }
}