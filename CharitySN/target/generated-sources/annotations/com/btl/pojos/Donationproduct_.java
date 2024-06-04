package com.btl.pojos;

import com.btl.pojos.Auction;
import com.btl.pojos.Posts;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-04T13:43:41")
@StaticMetamodel(Donationproduct.class)
public class Donationproduct_ { 

    public static volatile CollectionAttribute<Donationproduct, Auction> auctionCollection;
    public static volatile SingularAttribute<Donationproduct, String> image;
    public static volatile SingularAttribute<Donationproduct, Integer> iddonationProduct;
    public static volatile SingularAttribute<Donationproduct, Long> price;
    public static volatile SingularAttribute<Donationproduct, Date> created;
    public static volatile CollectionAttribute<Donationproduct, Posts> postsCollection;
    public static volatile SingularAttribute<Donationproduct, String> name;

}