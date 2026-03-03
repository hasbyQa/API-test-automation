package com.hasby.apitest.comments;

import java.util.HashMap;
import java.util.Map;

public class CommentPayload {
    public static Map<String, Object> create() {
        Map<String, Object> comment = new HashMap<>();
        comment.put("postId", 1);
        comment.put("name", "Test Comment");
        comment.put("email", "test@example.com");
        comment.put("body", "This is a test comment body.");
        return comment;
    }

    public static Map<String, Object> update() {
        Map<String, Object> comment = new HashMap<>();
        comment.put("postId", 1);
        comment.put("id", 1);
        comment.put("name", "Updated Comment");
        comment.put("email", "updated@example.com");
        comment.put("body", "This comment has been updated.");
        return comment;
    }
}
