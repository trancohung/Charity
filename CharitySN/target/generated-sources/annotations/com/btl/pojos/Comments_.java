package com.btl.pojos;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-11-04T13:41:53")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, String> image;
    public static volatile SingularAttribute<Comments, Date> createdDate;
    public static volatile SingularAttribute<Comments, String> sticker;
    public static volatile SingularAttribute<Comments, Posts> postId;
    public static volatile SingularAttribute<Comments, Integer> idcomments;
    public static volatile SingularAttribute<Comments, Users> userId;
    public static volatile SingularAttribute<Comments, String> content;

}