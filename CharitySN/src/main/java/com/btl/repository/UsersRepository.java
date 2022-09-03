/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Users;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface UsersRepository {
    boolean addUser(Users users);
    List<Users> getUsers(String username);
    
    
}
