package com.mycompany.developerstimetracker.controller;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import com.mycompany.developerstimetracker.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
<<<<<<< HEAD
=======
import java.time.Year;
>>>>>>> master
import java.util.List;

/**
 * Created by AkimPC on 26.04.2016.
 */

@Controller
@RequestMapping("users")
public class DataController implements Serializable{

    @Autowired
    private DataHandler dataHandler;

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/admin/time/descriptions", method = RequestMethod.GET )
    public @ResponseBody List<User> getUsers() {
        return dataHandler.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return dataHandler.getSingleUser(id);
    }

    @RequestMapping(value = "/{id}/time/descriptions/{limit}", method = RequestMethod.GET )
    public @ResponseBody List<Time> getUserTimeAndDescription(@PathVariable("id") int id,
                                                              @PathVariable("limit") int limit) {
        return dataHandler.timeHandler(id, limit);
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST )
    public @ResponseBody User addNewUser(@RequestBody UserTO newUser) {
        dataService.convertToUserEntity(newUser);
        return dataHandler.addNewUser(dataService.getConvertedUser());
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT )
    public @ResponseBody Time updateUserTimeAndDescriptions(@PathVariable("id") Integer id,
                                                                @RequestBody TimeTO newTime) {
        dataService.convertToTimeEntity(newTime);
        return dataHandler.updateUserTime(dataService.getConvertedTime(), id);
    }

    @RequestMapping(value = "/{id}/totaltime", method = RequestMethod.GET )
    public @ResponseBody int getTotalTime(@PathVariable("id") int id) {
        Month currentMonth = LocalDate.now().getMonth();
        int currentYear  = LocalDate.now().getYear();
        return dataHandler.getTotalTime(currentMonth , currentYear, id);
    }

}