package com.mycompany.developerstimetracker.handler.impl;

import com.mycompany.developerstimetracker.dao.UserDAO;
import com.mycompany.developerstimetracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AkimPC on 27.07.2016.
 */
public class URLAuthenticationHandlerImpl implements AuthenticationSuccessHandler{

    @Autowired
    private UserDAO userDAO;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDAO.findUserByLogin(authentication.getName());
        Integer userId=user.getUserId();
        response.sendRedirect("/DevelopersTimeTracker/users/" + userId);
        clearAuthenticationAttributes(request);

    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}
