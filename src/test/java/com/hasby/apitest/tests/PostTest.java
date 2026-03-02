package com.hasby.apitest.tests;

import com.hasby.apitest.base.BaseTest;
import com.hasby.apitest.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("POST Requests")
public class PostTest extends BaseTest {

//    Create a new post successfully
    @Test
    @Order(1)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("POST /posts - Create new post returns 201")
    @Description("Verify POST /posts creates a new post and returns 201 with correct data")
    public void testCreatePost(){
        given()
                .spec(requestSpec)
                .body(TestData.createPostPayload())
        .when()
                .post(TestData.POSTS_ENDPOINT)
        .then()
                .statusCode(TestData.STATUS_CREATED)
                .body("title", equalTo("Test Post Title"))
                .body("body", equalTo("This is a test post body content."))
                .body("userId", equalTo(TestData.VALID_USER_ID))
                .body("id", notNullValue());
    }

//    Create post with partial data
    @Test
    @Order(2)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("POST /posts - Partial data still creates a post")
    @Description("Verify POST /posts with only title still returns 201")
    public void testCreatePostPartialData(){
        given()
                .spec(requestSpec)
                .body(TestData.partialPostPayload())
        .when()
                .post(TestData.POSTS_ENDPOINT)
        .then()
                .statusCode(TestData.STATUS_CREATED)
                .body("title", equalTo("Partial Post"))
                .body("id", notNullValue());
    }

//    Create post with empty body
    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("POST /posts - Empty body still returns 201")
    @Description("Verify POST /posts with empty JSON object still creates a resource")
    public void testCreatePostEmptyBody(){
        given()
                .spec(requestSpec)
                .body("{}")
        .when()
                .post(TestData.POSTS_ENDPOINT)
        .then()
                .statusCode(TestData.STATUS_CREATED)
                .body("id", notNullValue());
    }

//    Verify response time is acceptable
    @Test
    @Order(4)
    @Severity(SeverityLevel.MINOR)
    @DisplayName("POST /posts - Response time under threshold")
    @Description("Verify POST response completes within acceptable time")
    public void testCreatePostResponseTime(){
        given()
                .spec(requestSpec)
                .body(TestData.performanceTestPayload())
        .when()
                .post(TestData.POSTS_ENDPOINT)
        .then()
                .statusCode(TestData.STATUS_CREATED)
                .time(lessThan(TestData.MAX_RESPONSE_TIME_MS));
    }
}
