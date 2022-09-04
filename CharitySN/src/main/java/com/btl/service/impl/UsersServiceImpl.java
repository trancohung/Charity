/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.pojos.Users;
import com.btl.repository.UsersRepository;
import com.btl.service.UsersService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service("userDetailsService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Users> getUsers(String username) {
        return this.usersRepository.getUsers(username);
    }

    @Override
    public boolean addUser(Users users) {
        String pass = users.getPassword();
        users.setPassword(this.passwordEncoder.encode(pass));
        if(users.getUserRole() == null)
            users.setUserRole(Users.USER);
        
        try {
            Map r = this.cloudinary.uploader().upload(users.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            users.setAvatar((String) r.get("secure_url"));
        return this.usersRepository.addUser(users);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = this.getUsers(username);
        if (users.isEmpty())
            throw new UsernameNotFoundException("User does not exist!!!");
        Users user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new org.springframework.security.core
                .userdetails.User(user.getUsername(), user.getPassword(), auth);
    }
    
}
