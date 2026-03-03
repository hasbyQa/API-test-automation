package com.hasby.apitest.users;

import java.util.HashMap;
import java.util.Map;

public class UserPayload {
    public static Map<String, Object> create() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Test User");
        user.put("username", "testuser");
        user.put("email", "test@example.com");
        return user;
    }

    public static Map<String, Object> update() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1);
        user.put("name", "Updated User");
        user.put("username", "updateduser");
        user.put("email", "updated@example.com");
        return user;
    }
}
