package com.ca.formation.formationdemo1.controllers.api;

import com.ca.formation.formationdemo1.dto.PersonneDTO;
import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.services.PersonneService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v2/personnes")
public class ApiPersonneController {

    private static String bye="Bye bye";
    private  static String hello="Bonjour tout le monde";
    private  static  String ok="OK";
    private final PersonneService personneService;

    private  Personne personneResponse=new Personne();

    private  Personne pers=new Personne();

    public ApiPersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    /**
     * - GET /api/v1/personnes
     * - POST /api/v1/personnnes
     * - PATCH /api/v1/personnnes/{id}
     * - PUT /api/v1/personnnes/{id}
     * - GET /api/v1/personnes/{id}
     * - DELETE /api/v1/personnes/{id}
     * - GET /api/v1/personnes/search?nom="Jean"
     */

    @PreAuthorize("hasAuthority('"+ Role.READ+"')")
    @GetMapping("/hello")
    public String hello(){


        return hello;
    }

    @PreAuthorize("hasAuthority('"+ Role.READ+"')")
    @GetMapping("/bye")
    public  String byebye(){


        return bye;
    }

    /**
     * /api/v1/personnes
     * @return List Personne
     */
    @GetMapping
    public ResponseEntity<List<Personne>> getToutPersonne(){
        List<Personne> personnes = personneService.getPersonnes();
        return ResponseEntity.ok().body(personnes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonne(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        pers = personneService.getPersonne(id);
       return ResponseEntity.ok().body(pers);
    }

    @PostMapping
    public ResponseEntity<Personne> addPersonne(@RequestBody PersonneDTO personne){
        personneResponse = personneService.addPersonne(pers);
        return ResponseEntity.ok().body(personneResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable(value="id") Long id, @RequestBody PersonneDTO personneRequest ) throws ResourceNotFoundException {

        personneResponse = personneService.updatePersonne(id,pers);

        return ResponseEntity.ok().body(personneResponse);
    }

    @DeleteMapping("/{id}")
    public String deletePersonne(@PathVariable(value="id") Long id){
        personneService.deletePersonne(id);
        return ok;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Personne>> getPersonneParNom(@RequestParam(name = "nom") String nom){
        List<Personne> personnes = personneService.getPersonneParNom(nom);
        return ResponseEntity.ok().body(personnes);
    }

}
