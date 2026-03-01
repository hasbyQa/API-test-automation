package com.hasby.apitest.data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    public static final String USERS_ENDPOING = "/api/users";

//    USER IDS
    public static final int VALID_USER_ID = 2;
    public static final int INVALID_USER_ID = 999;
    public static final int DEFAULT_PAGE = 2;

//    EXPECTED STATUS CODES
    public static final int STATUS_OK = 200;
    public static final int STATUS_CREATED = 201;
    public static final int STATUS_NO_CONTENT = 204;
    public static final int STATUS_NOT_FOUND = 404;
    public static final int STATUS_FORBIDDEN = 403;
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;

//    EXPECTED RESPONSE VALUES (for GET /api/users/2)
    public static final String EXPECTED_EMAIL = "janet.weaver@reqres.in";
    public static final String EXPECTED_FIRST_NAME = "Janet";
    public static final String EXPECTED_LAST_NAME = "Weaver";
    public static final int EXPECTED_PAGE_SIZE = 6;

//    PERFORMANCE THRESHOLDS
    public static final long MAX_RESPONSE_TIME_MS = 5000L;

//    REGEX PATTERNS
    public static final String ISO_TIMESTAMP_PATTERN = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";

//    Full user payload for POST
    public static Map<String, String> createUserPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "Hasby");
        user.put("job", "QA");
        return user;
    }

//    Partial user payload(name only)
    public static Map<String, String> partialUserPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "John");
        return user;
    }

//    updated user payload for PUT
    public static Map<String, String> updatedUserPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "Hasby Updated");
        user.put("job", "QA Engineer");
        return user;
    }

//    Partial update payload for PUT
    public static Map<String, String> partialUpdatePayload(){
        Map<String, String> user = new HashMap<>();
        user.put("job", "Testing Engineer");
        return user;
    }

//    Payload for performance tests
    public static Map<String, String> performanceTestPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "SpeedTest");
        user.put("job", "Tester");
        return user;
    }

//    Payload for timestamp validation
    public static Map<String, String> timestampTestPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "Timestamp Test");
        user.put("job", "Validator");
        return user;
    }

//    payload for header validation
    public static Map<String, String> headerTestPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "Header Test");
        user.put("job", "Quality Assurance");
        return user;
    }
}
