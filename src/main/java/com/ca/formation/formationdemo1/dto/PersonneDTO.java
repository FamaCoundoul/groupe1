package com.ca.formation.formationdemo1.dto;


import com.ca.formation.formationdemo1.models.Personne;

public class PersonneDTO {

    private  Personne pers=new Personne();

    public PersonneDTO(Personne pers) {
        this.pers = pers;
    }

    @Override
    public String toString() {
        return "Personne " +
                "id="+ pers.getId();
    }


}
