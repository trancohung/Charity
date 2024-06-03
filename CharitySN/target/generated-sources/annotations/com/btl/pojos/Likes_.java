package com.btl.pojos;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-04T13:41:53")
@StaticMetamodel(Likes.class)
public class Likes_ { 

    public static volatile SingularAttribute<Likes, Integer> idlikes;
    public static volatile SingularAttribute<Likes, Posts> postId;
    public static volatile SingularAttribute<Likes, Users> userId;

}