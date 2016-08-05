package com.mycompany.developerstimetracker.controller;

import com.mycompany.developerstimetracker.dto.TimeTO;
import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.Project;
import com.mycompany.developerstimetracker.entity.Time;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Created by AkimPC on 26.04.2016.
 */

@Controller
@RequestMapping("users")
public class DataController implements Serializable{

    @Autowired
    private DataHandler dataHandler;

        @RequestMapping(value = "/admin/time/descriptions", method = RequestMethod.GET )
    public @ResponseBody List<User> getUsers() {
        return dataHandler.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return dataHandler.getSingleUser(id);
    }

    @RequestMapping(value = "/{id}/time/descriptions/bylimit/{limit}", method = RequestMethod.GET )
    public @ResponseBody List<Time> getUserTimeAndDescriptionByLimit(@PathVariable("id") int id,
                                                              @PathVariable("limit") int limit) {
        return dataHandler.timeHandlerByLimit(id, limit);
    }

    @RequestMapping(value = "/{id}/time/descriptions/bymonth/{month}", method = RequestMethod.GET )
    public @ResponseBody List<Time> getUserTimeAndDescriptionByMonth(@PathVariable("id") int id,
                                                              @PathVariable("month") Month month) {
        return dataHandler.timeHandlerByMonth(id, month);
    }

    @RequestMapping(value = "/{id}/time/descriptions/byrange/{fromDate}/{toDate}", method = RequestMethod.GET )
    public @ResponseBody List<Time> getUserTimeAndDescriptionByRange(@PathVariable("id") int id,
                                                                     @PathVariable("fromDate") Date fromDate,
                                                                     @PathVariable("toDate") Date toDate) {
        return dataHandler.timeHandlerByRange(id, fromDate, toDate);
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST )
    public @ResponseBody User addNewUser(@RequestBody UserTO newUser) {
        return dataHandler.addNewUser(newUser);
    }

    @RequestMapping(value = "/{userid}/{projectname}/update", method = RequestMethod.PUT )
    public @ResponseBody Time updateUserTimeAndDescriptions(@PathVariable("userid") Integer userId,
                                                            @PathVariable("projectname") String projectName,
                                                                @RequestBody TimeTO newTime) {
        return dataHandler.updateUserTime(userId,projectName,newTime);
    }

    @RequestMapping(value = "/{id}/totaltime", method = RequestMethod.GET )
    public @ResponseBody int getTotalTime(@PathVariable("id") int id) {
        Month currentMonth = LocalDate.now().getMonth();
        return dataHandler.getTotalTime(currentMonth ,id);
    }

    @RequestMapping(value ="/availableprojects",  method = RequestMethod.GET)
    public @ResponseBody List<Project> getAvailableProjects() {
        return dataHandler.getAvailableProjects();
    }

    @RequestMapping(value ="/report",  method = RequestMethod.GET)
    public @ResponseBody String getResport() throws JRException {
        return dataHandler.getReport();
    }

}