package com.hasby.apitest.data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    public static final String POSTS_ENDPOINT = "/posts";

//    IDS & PARAMS
    public static final int VALID_POST_ID = 1;
    public static final int INVALID_POST_ID = 999;
    public static final int VALID_USER_ID = 1;
    public static final int POSTS_LIMIT = 5;

//    EXPECTED STATUS CODES
    public static final int STATUS_OK = 200;
    public static final int STATUS_CREATED = 201;
    public static final int STATUS_NOT_FOUND = 404;

//    EXPECTED RESPONSE VALUES (for GET /posts/1)
    public static final int EXPECTED_USER_ID = 1;
    public static final String EXPECTED_TITLE_START = "sunt aut facere";

//    PERFORMANCE THRESHOLDS
    public static final long MAX_RESPONSE_TIME_MS = 5000L;

//    REGEX PATTERNS
    public static final String ISO_TIMESTAMP_PATTERN = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";

//    Full post payload for POST
    public static Map<String, Object> createPostPayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Test Post Title");
        post.put("body", "This is a test post body content.");
        post.put("userId", 1);
        return post;
    }

//    Partial post payload(title only)
    public static Map<String, Object> partialPostPayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Partial Post");
        return post;
    }

//    updated post payload for PUT
    public static Map<String, Object> updatePostPayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("id", 1);
        post.put("title", "Updated Post Title");
        post.put("body", "This post body has been updated.");
        post.put("userId", 1);
        return post;
    }

//    Partial update payload for PUT
    public static Map<String, Object> partialUpdatePayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Only Title Updated");
        return post;
    }

//    Payload for performance tests
    public static Map<String, Object> performanceTestPayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Speed Test");
        post.put("body", "Performance test body.");
        post.put("userId", 1);
        return post;
    }

//    payload for header validation
    public static Map<String, Object> headerTestPayload() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "Header Test");
        post.put("body", "Header test body.");
        post.put("userId", 1);
        return post;
    }
}
