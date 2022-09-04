package com.btl.pojos;

import com.btl.pojos.Donationproduct;
import com.btl.pojos.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T15:55:10")
@StaticMetamodel(Auction.class)
public class Auction_ { 

    public static volatile SingularAttribute<Auction, Integer> idAuction;
    public static volatile SingularAttribute<Auction, Date> created;
    public static volatile SingularAttribute<Auction, Donationproduct> donationProductid;
    public static volatile SingularAttribute<Auction, Integer> pay;
    public static volatile SingularAttribute<Auction, Users> userId;

}