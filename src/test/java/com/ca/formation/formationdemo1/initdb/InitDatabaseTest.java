package com.ca.formation.formationdemo1.initdb;

import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.models.Utilisateur;
import com.ca.formation.formationdemo1.services.UtilisateurService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.boot.system.SystemProperties.get;

public class InitDatabaseTest {
    @Mock
    UtilisateurService utilisateurService;
    @InjectMocks
    InitDatabase initDatabase;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOnApplicationEvent() throws Exception {
        when(utilisateurService.registration(any())).thenReturn(new Utilisateur("username", "password", "name", Set.of(new Role(Role.READ))));

        initDatabase.onApplicationEvent(null);
    }

}
