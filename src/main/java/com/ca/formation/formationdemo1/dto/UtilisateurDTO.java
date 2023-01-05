package com.ca.formation.formationdemo1.dto;

import com.ca.formation.formationdemo1.models.Role;

import java.util.HashSet;
import java.util.Set;


public class UtilisateurDTO {

    private Long id;

    private boolean enabled = true;
    private String username;
    private String password;
    private String name;
    private Set<Role> authoritie = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
