package com.btl.pojos;

import com.btl.pojos.Comments;
import com.btl.pojos.Donationproduct;
import com.btl.pojos.Hashtag;
import com.btl.pojos.Image;
import com.btl.pojos.Likes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T16:59:21")
@StaticMetamodel(Posts.class)
public class Posts_ { 

    public static volatile CollectionAttribute<Posts, Hashtag> hashtagCollection;
    public static volatile CollectionAttribute<Posts, Donationproduct> donationproductCollection;
    public static volatile SingularAttribute<Posts, Integer> idPosts;
    public static volatile SingularAttribute<Posts, Date> created;
    public static volatile CollectionAttribute<Posts, Image> imageCollection;
    public static volatile SingularAttribute<Posts, Integer> likeCount;
    public static volatile CollectionAttribute<Posts, Comments> commentsCollection;
    public static volatile CollectionAttribute<Posts, Likes> likesCollection;
    public static volatile SingularAttribute<Posts, Integer> userId;
    public static volatile SingularAttribute<Posts, String> content;

}