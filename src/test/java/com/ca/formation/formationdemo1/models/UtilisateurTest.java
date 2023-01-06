package com.ca.formation.formationdemo1.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

public class UtilisateurTest {
    @Mock
    Set<Role> autorisation;
    @InjectMocks
    Utilisateur utilisateur;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsAccountNonExpired() throws Exception {
        boolean result = utilisateur.isAccountNonExpired();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsAccountNonLocked() throws Exception {
        boolean result = utilisateur.isAccountNonLocked();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCredentialsNonExpired() throws Exception {
        boolean result = utilisateur.isCredentialsNonExpired();
        Assert.assertEquals(true, result);
    }


}

