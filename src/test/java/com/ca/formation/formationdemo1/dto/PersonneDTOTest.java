package com.ca.formation.formationdemo1.dto;

import com.ca.formation.formationdemo1.models.Personne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class PersonneDTOTest {
    @Mock
    Personne pers;
    @InjectMocks
    PersonneDTO personneDTO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testToString() throws Exception {
        when(pers.getId()).thenReturn(Long.valueOf(1));

        String result = personneDTO.toString();
        Assert.assertEquals("Personne " + "id="+ 1, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme