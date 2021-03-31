package com.bsy.common.api;

public class UserApi {

    public static final String USER_SERVICE = "EUREKA-PROVIDER";

    public static  final String USER_URL_PREFIX = "http://" + USER_SERVICE;

    public static final String LIST_TOP_USERS = USER_URL_PREFIX + "/user/last";

    public static final String Add_USER = USER_URL_PREFIX + "/user/add";

    public static final String Hello_USER = USER_URL_PREFIX + "user/hello";
}
