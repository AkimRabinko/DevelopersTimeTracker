package com.mycompany.developerstimetracker.controller;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by AkimPC on 29.07.2016.
 */
public class DataControllerTest {

    private DataController mockedDataController;

    @Mock
    private User user1;

    @Mock
    private User user2;

    @Mock
    private Time time1;

    @Mock
    private Time time2;

    @Mock
    private UserTO userTO;

    @Mock
    private TimeTO timeTO;

    @Before
    public void setUp() {
        mockedDataController = mock(DataController.class);
        user1 = new User("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");
        user2 = new User("Jonny" , "1111", "John", "Smith" , "Programmer" , "ROLE_ADMIN");
        time1 = new Time(3, "ddddd" , java.sql.Date.valueOf(LocalDate.now()));
        time2 = new Time(5, "aaaaa" , java.sql.Date.valueOf(LocalDate.now()));
        timeTO = new TimeTO(3, "ddddd" , java.sql.Date.valueOf(LocalDate.now()));
        userTO = new UserTO("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");

        when(mockedDataController.getUsers()).thenReturn(Arrays.asList(user1, user2));
        when(mockedDataController.getUserById(2)).thenReturn(user2);
        when(mockedDataController.addNewUser(userTO)).thenReturn(user1);
    }

    @Test
    public void testGetUsers() {
        List<User> allUsers= mockedDataController.getUsers();
        User singleUser = allUsers.get(1);
        assertEquals("Jonny", singleUser.getUserLogin());
        assertEquals("1111", singleUser.getUserPassword());
        assertEquals("John", singleUser.getUserName());
        assertEquals("Smith", singleUser.getUserLastName());
        assertEquals("Programmer", singleUser.getUserPosition());
        assertEquals("ROLE_ADMIN", singleUser.getUserRole());
    }

    @Test
    public void testGetUserById () {
        User singleUser = mockedDataController.getUserById(2);
        assertEquals("Jonny", singleUser.getUserLogin());
        assertEquals("1111", singleUser.getUserPassword());
        assertEquals("John", singleUser.getUserName());
        assertEquals("Smith", singleUser.getUserLastName());
        assertEquals("Programmer", singleUser.getUserPosition());
        assertEquals("ROLE_ADMIN", singleUser.getUserRole());
    }



    @Test
    public void testAddUser() {
        User addUser = mockedDataController.addNewUser(userTO);
        assertEquals("Akim", addUser.getUserLogin());
        assertEquals("1111", addUser.getUserPassword());
        assertEquals("Akim", addUser.getUserName());
        assertEquals("Rabinko", addUser.getUserLastName());
        assertEquals("Programmer", addUser.getUserPosition());
        assertEquals("ROLE_DEVELOPER", addUser.getUserRole());
    }
}
