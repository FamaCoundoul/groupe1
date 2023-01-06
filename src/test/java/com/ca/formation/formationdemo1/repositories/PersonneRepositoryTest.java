package com.ca.formation.formationdemo1.repositories;

import com.ca.formation.formationdemo1.models.Personne;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PersonneRepositoryTest {

    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void ajouterPersonne() {
        Personne personne = personneRepository.save(new Personne("tonux", "samb", 5));
        assertNotNull(personne);
        org.junit.Assert.assertEquals("tonux",personne.getNom());
    }

    // TODO: ajouter un test sur les autres methodes comme delete, findByNom, etc... fait
    @Test
    public  void findAll(){
        List<Personne> personList= (List<Personne>) personneRepository.findAll();
        assertEquals("Beau",personList.get(0).getNom());
        org.junit.Assert.assertEquals(4,personList.size());

    }
   @Test
    public void update(){
       Personne personne = personneRepository.save(new Personne("tonux1", "samb1", 35));
       personne.setNom("Fall");
       assertNotNull(personne);
       assertEquals("Fall",personne.getNom() );
    }

    @Test
    public  void delete(){
        Personne personne = new Personne("nom", "prenom", 20);
        personneRepository.save(personne);

        personneRepository.delete(personne);

        assertThat(personneRepository.findById(personne.getId()));
    }


    @Test
    public void findById(){
        //Given
        Personne pers = personneRepository.save(new Personne("badiane", "khady", 24));
        //When
        Optional<Personne> person = personneRepository.findById(pers.getId());
        //Then
        assertNotNull(person);
        assertEquals("badiane", person.get().getNom());

    }



    @Test
    public void findByNom() {
        Personne personne1 = new Personne("nom", "prenom", 30);
        Personne personne2 = new Personne("coundoul", "fama", 20);
        personneRepository.save(personne1);
        personneRepository.save(personne2);
        List<Personne> personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);

        assertThat(personneRepository.findByNom("coundoul")).isNotNull();
        assertEquals(1, personneRepository.findByNom("coundoul").size());
    }

    @Test
    public void findByNomAndPrenom() {
        Personne personne1 = new Personne("nom1", "prenom1", 30);
        Personne personne2 = new Personne("nom1", "prenom2", 20);
        personneRepository.save(personne1);
        personneRepository.save(personne2);
        List<Personne> personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);

        assertThat(personneRepository.findByNomAndPrenom("nom1","prenom1")).isNotNull();
        assertEquals(1, personneRepository.findByNomAndPrenom("nom1","prenom1").size());
    }

    @Test
    public void findNomPrenom() {
        Personne personne1 = new Personne("nom11", "prenom11", 30);
        Personne personne2 = new Personne("nom12", "prenom22", 20);
        personneRepository.save(personne1);
        personneRepository.save(personne2);
        List<Personne> personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);

        assertThat(personneRepository.findNomPrenom("nom11","prenom11")).isNotNull();
        assertEquals(1, personneRepository.findNomPrenom("nom11","prenom11").size());
    }

    @Test
    public void findNomPrenom2() {
        Personne personne1 = new Personne("nom111", "prenom111", 30);
        Personne personne2 = new Personne("nom222", "prenom222", 20);
        personneRepository.save(personne1);
        personneRepository.save(personne2);
        List<Personne> personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);

        assertThat(personneRepository.findNomPrenom("nom111","prenom111")).isNotNull();
        assertEquals(1, personneRepository.findNomPrenom("nom222","prenom222").size());
    }

    @Test
    public void ageGreaterThan() {
        Personne personne1 = new Personne("nom1", "prenom1", 5);
        Personne personne2 = new Personne("nom2", "prenom2", 10);
        Personne personne3 = new Personne("nom3", "prenom3", 8);
        personneRepository.save(personne1);
        personneRepository.save(personne2);
        personneRepository.save(personne3);
        List<Personne> personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);
        personnes.add(personne3);

        Assert.assertEquals(personnes.size(), personneRepository.ageGreaterThan(10).size());
    }
}