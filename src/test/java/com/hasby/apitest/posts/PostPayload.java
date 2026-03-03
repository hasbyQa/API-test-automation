package com.hasby.apitest.posts;

import java.util.HashMap;
import java.util.Map;

public class PostPayload {
    public static Map<String, Object> create() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Test Post Title");
        post.put("body", "This is test post body content.");
        post.put("userId", 1);
        return post;
    }

    public static Map<String, Object> update() {
        Map<String, Object> post = new HashMap<>();
        post.put("id", 1);
        post.put("title", "Updated Post Title");
        post.put("body", "Updated post body content.");
        post.put("userId", 1);
        return post;
    }
}
