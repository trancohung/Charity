/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Likes;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ACER
 */
@Component
public interface LikeRepository {
    List<Likes> getLikesByPostId(int postId);
}
