package com.btl.pojos;

import com.btl.pojos.Auction;
import com.btl.pojos.Posts;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-04T15:55:10")
@StaticMetamodel(Donationproduct.class)
public class Donationproduct_ { 

    public static volatile CollectionAttribute<Donationproduct, Auction> auctionCollection;
    public static volatile SingularAttribute<Donationproduct, String> image;
    public static volatile SingularAttribute<Donationproduct, Integer> iddonationProduct;
    public static volatile SingularAttribute<Donationproduct, BigDecimal> price;
    public static volatile SingularAttribute<Donationproduct, String> name;
    public static volatile SingularAttribute<Donationproduct, Posts> postId;
    public static volatile SingularAttribute<Donationproduct, Short> status;

}