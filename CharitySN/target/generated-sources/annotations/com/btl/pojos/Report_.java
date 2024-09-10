package com.btl.pojos;

import com.btl.pojos.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-10T17:42:15")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Integer> idreport;
    public static volatile SingularAttribute<Report, Users> userId;
    public static volatile SingularAttribute<Report, String> content;

}