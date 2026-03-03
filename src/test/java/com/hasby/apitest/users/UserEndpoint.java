package com.hasby.apitest.users;

public class UserEndpoint {
    public static final String BASE = "/users";
    public static final String BY_ID = "/users/{id}";

//    Relationship endpoints
    public static final String POSTS = "/users/{id}/posts";
    public static final String ALBUMS = "/users/{id}/albums";
    public static final String TODOS = "/users/{id}/todos";
}
