package com.baixiang.chuxing.user.model.mongo;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -258301692L;

    public static final QUser user = new QUser("user");

    public final StringPath account = createString("account");

    public final StringPath address = createString("address");

    public final StringPath avatar = createString("avatar");

    public final StringPath checkBy = createString("checkBy");

    public final DateTimePath<java.util.Date> checkDatetime = createDateTime("checkDatetime", java.util.Date.class);

    public final StringPath checkReason = createString("checkReason");

    public final NumberPath<Integer> checkStatus = createNumber("checkStatus", Integer.class);

    public final StringPath city = createString("city");

    public final DateTimePath<java.util.Date> createDatetime = createDateTime("createDatetime", java.util.Date.class);

    public final StringPath driverLicense1 = createString("driverLicense1");

    public final StringPath driverLicense2 = createString("driverLicense2");

    public final NumberPath<Integer> driverLicenseCheckStatus = createNumber("driverLicenseCheckStatus", Integer.class);

    public final DateTimePath<java.util.Date> driverLicenseDate = createDateTime("driverLicenseDate", java.util.Date.class);

    public final StringPath driverLicenseNo = createString("driverLicenseNo");

    public final DateTimePath<java.util.Date> driverLicenseValidDate = createDateTime("driverLicenseValidDate", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath idNo = createString("idNo");

    public final StringPath idPhoto1 = createString("idPhoto1");

    public final StringPath idPhoto2 = createString("idPhoto2");


    public final NumberPath<Integer> idPhotoCheckStatus = createNumber("idPhotoCheckStatus", Integer.class);

    public final StringPath lastName = createString("lastName");

    public final DateTimePath<java.util.Date> loginDatetime = createDateTime("loginDatetime", java.util.Date.class);

    public final StringPath payChannel = createString("payChannel");

    public final StringPath status = createString("status");

    public final DateTimePath<java.util.Date> updateDatetime = createDateTime("updateDatetime", java.util.Date.class);

    public final StringPath userName = createString("userName");

    public final StringPath company = createString("company");

    public final NumberPath<Integer> vehicleNum = createNumber("vehicleNum", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

