package com.ca.formation.formationdemo1.controllers.api;


import com.ca.formation.formationdemo1.dto.PersonneDTO;
import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.services.PersonneService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ApiPersonneControllerTest {
    @Mock
    PersonneService personneService;
    @Mock
    Personne personneResponse;
    @Mock
    Personne pers;
    @InjectMocks
    ApiPersonneController apiPersonneController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }





    @Test
    public void testDeletePersonne() throws Exception {
        String result = apiPersonneController.deletePersonne(Long.valueOf(1));
        Assert.assertEquals("OK", result);
    }

    @Test
    public void testGetPersonneParNom() throws Exception {
        when(personneService.getPersonneParNom(anyString())).thenReturn(List.of(new Personne("nomXX", "prenomXX", 0)));

        ResponseEntity<List<Personne>> result = apiPersonneController.getPersonneParNom("nomXX");
        Assert.assertEquals(1, result.getBody().size());
    }

    @Test
    public void testAddPersonne() {
        when(personneService.addPersonne(any())).thenReturn(new Personne("nomKK", "prenomKK", 50));
        personneResponse = personneService.addPersonne(new Personne("nomKK", "prenomKK", 50));
        ResponseEntity<Personne>obj= ResponseEntity.ok().body(personneResponse);
        ResponseEntity<Personne> result = apiPersonneController.addPersonne(new PersonneDTO(new Personne("nom", "prenom", 0)));
        Assertions.assertEquals(obj, result);
    }
    @Test
   public void testUpdatePersonne() throws ResourceNotFoundException {
        when(personneService.updatePersonne(anyLong(), any())).thenReturn(new Personne("nomLL", "prenomLL", 90));
        personneResponse = personneService.updatePersonne(1L,new Personne("nomLL", "prenomLL", 90));
        ResponseEntity<Personne>obj= ResponseEntity.ok().body(personneResponse);
        ResponseEntity<Personne> result = apiPersonneController.updatePersonne(Long.valueOf(1), new PersonneDTO(new Personne("nom", "prenom", 0)));
        Assertions.assertEquals(obj, result);
    }

}

