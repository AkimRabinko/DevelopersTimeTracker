package com.mycompany.developerstimetracker.service;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by AkimPC on 29.07.2016.
 */
public class DataServiceTest {

    private DataService mockedDataService;

    @Mock
    private TimeTO timeTO;

    @Mock
    private UserTO userTO;

    @Before
    public void setUp() {
        mockedDataService = mock(DataService.class);
        timeTO = new TimeTO(3, "ddddd" , java.sql.Date.valueOf(LocalDate.now()));
        userTO = new UserTO("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");

        when(mockedDataService.getConvertedTime()).thenReturn(new Time(3, "ddddd" , java.sql.Date.valueOf(LocalDate.now())));
        when(mockedDataService.getConvertedUser()).thenReturn(new User("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER"));
    }

    @Test
    public void testGetConvertedTime() {
        mockedDataService.convertToTimeEntity(timeTO);
        assertEquals("ddddd" , mockedDataService.getConvertedTime().getDescription());
        assertEquals(3 , mockedDataService.getConvertedTime().getTime());
        assertEquals( java.sql.Date.valueOf(LocalDate.now()) , mockedDataService.getConvertedTime().getDate());
    }

    @Test
    public void testGetConvertedUser() {
        mockedDataService.convertToUserEntity(userTO);
        assertEquals("Akim" , mockedDataService.getConvertedUser().getUserLogin());
        assertEquals("1111" , mockedDataService.getConvertedUser().getUserPassword());
        assertEquals("Akim" , mockedDataService.getConvertedUser().getUserName());
        assertEquals("Rabinko" , mockedDataService.getConvertedUser().getUserLastName());
        assertEquals("Programmer" , mockedDataService.getConvertedUser().getUserPosition());
        assertEquals("ROLE_DEVELOPER" , mockedDataService.getConvertedUser().getUserRole());
    }
}
