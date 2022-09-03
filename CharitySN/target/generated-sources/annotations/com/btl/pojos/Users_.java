package com.btl.pojos;

import com.btl.pojos.Auction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T16:59:21")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Auction> auctionCollection;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Date> created;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Integer> idUsers;
    public static volatile SingularAttribute<Users, String> fullname;
    public static volatile SingularAttribute<Users, String> userRole;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}