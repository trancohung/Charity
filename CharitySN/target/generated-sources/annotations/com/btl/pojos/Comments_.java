package com.btl.pojos;

import com.btl.pojos.Posts;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T16:59:21")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, String> image;
    public static volatile SingularAttribute<Comments, String> sticker;
    public static volatile SingularAttribute<Comments, Posts> postId;
    public static volatile SingularAttribute<Comments, String> reply;
    public static volatile SingularAttribute<Comments, Integer> idcomments;
    public static volatile SingularAttribute<Comments, Integer> userId;
    public static volatile SingularAttribute<Comments, String> content;

}