package com.ca.formation.formationdemo1.models;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilisateur implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean enabled = true;
    private String username;
    private String password;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> autorisation = new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur(String username, String password, String name, Set<Role> authorize) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.autorisation = authorize;
    }



    public boolean isEnabled() {
        return enabled;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }



    @Override
    public Set<Role> getAuthorities() {
        return getAutorisation();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }



    public Set<Role> getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(Set<Role> authorize) {
        this.autorisation = authorize;
    }
}
