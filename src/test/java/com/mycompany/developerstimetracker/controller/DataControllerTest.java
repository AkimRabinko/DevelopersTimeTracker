package com.mycompany.developerstimetracker.controller;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import com.mycompany.developerstimetracker.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by AkimPC on 29.07.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataControllerTest {

    @InjectMocks
    private DataController dataController = new DataController();

    @Mock
    private DataHandler dataHandler;

    @Test
    public void testGetUsers() {
        User user = new User("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");
        List<User> expected = Arrays.asList(user);
        when(dataHandler.getAllUsers()).thenReturn(expected);
        List<User> actual = dataController.getUsers();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetUserById () {
        User user = new User("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");
        when(dataHandler.getSingleUser(1)).thenReturn(user);
        User actual = dataController.getUserById(1);
        assertEquals(user, actual);
    }

    @Test
    public void testUpdateTimeAndDescription () {
        TimeTO timeTO = new TimeTO(3, "test", java.sql.Date.valueOf(LocalDate.now()));
        Time time = new Time(3, "test", java.sql.Date.valueOf(LocalDate.now()));
        when(dataHandler.updateUserTime(1, "project", timeTO)).thenReturn(time);
        assertEquals(timeTO.getDescription(),  dataController.updateUserTimeAndDescriptions(1, "project", timeTO).getDescription());
    }

    @Test
    public void testAddUser() {
        UserTO userTO = new UserTO("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");
        User user = new User("Akim" , "1111", "Akim", "Rabinko" , "Programmer" , "ROLE_DEVELOPER");
        when(dataHandler.addNewUser(userTO)).thenReturn(user);
        assertEquals(userTO.getUserRole(), dataController.addNewUser(userTO).getUserRole());
    }

    @Test
    public void testAddNewProject() {
        Project expected = new Project();
        expected.setProjectName("test");
        when(dataHandler.addNewProject(expected)).thenReturn(expected);
        Project actual = dataController.addNewProject(expected);
        assertEquals(expected, actual);
    }
}
