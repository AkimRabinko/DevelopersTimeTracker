package com.mycompany.developerstimetracker.controller;

import com.mycompany.developerstimetracker.dto.UserTO;
import com.mycompany.developerstimetracker.entity.User;
import com.mycompany.developerstimetracker.handler.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Created by AkimPC on 05.07.2016.
 */
@Controller
@RequestMapping("users")
public class PageController {

    @Autowired
    private DataHandler dataHandler;

    private int adminId;

    @RequestMapping(value = "/admin")
    public String Start(HttpServletRequest request, ModelMap map) {
            map.put("userId", adminId);
        return "adminScreen";
    }

    @RequestMapping()
    public String logIn() {
        return "login";
    }

    @RequestMapping(value = "/admin/time/descriptions", produces = MediaType.TEXT_HTML_VALUE)
    public String getUsers(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", dataHandler.getAllUsers());
        return "allUsersScreen";
    }

    @RequestMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getUserById(@PathVariable int id, ModelMap map) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        currentDate.format(formatter);
        adminId = id;
        map.put("userId", id);
        map.put("currentDate" , currentDate);
        return "singleUserScreen";
    }

    @RequestMapping(value = "/admin/add", produces = MediaType.TEXT_HTML_VALUE)
    public String addNewUser(@ModelAttribute("newUser") UserTO newUser, HttpServletRequest request) {
        return "addUserScreen";
    }

    @RequestMapping(value = "/403")
    public String accessDenied() {

        ModelAndView model = new ModelAndView();
        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("userLogin", userDetail.getUsername());
        }
        return "403";
    }
}