/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Likes;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface LikeService {
    List<Likes> getLikesById(int postId);
}
