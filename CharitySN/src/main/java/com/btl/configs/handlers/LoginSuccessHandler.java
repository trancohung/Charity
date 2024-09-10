/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.configs.handlers;

import com.btl.pojos.Users;
import com.btl.service.UsersService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author ACER
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UsersService UsersDetailsService;
    


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication a) throws IOException, ServletException {
        Users u = this.UsersDetailsService.getUsers(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        
        response.sendRedirect("/CharitySN/");
    }    
}
