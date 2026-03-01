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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Feature("GET Requests")
public class GetTest extends BaseTest {

//    Get a list of users
    @Test
    @Order(1)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("GET /posts - List of posts returns 200")
    @Description("Verify GET /posts with limit returns correct number of posts")
    public void testGetListOfPosts(){
        given()
                .spec(requestSpec)
                .queryParam("_limit", TestData.POSTS_LIMIT)
        .when()
                .get(TestData.POSTS_ENDPOINT)
        .then()
                .statusCode(TestData.STATUS_OK)
                .body("$", hasSize(TestData.POSTS_LIMIT))
                .body("id", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()));
    }

//    Get a single post by ID
    @Test
    @Order(2)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("GET /posts/1 - Single post returns correct data")
    @Description("Verify GET /posts/1 returns post with correct userId, id, title, body")
    public void testGetSinglePost(){
        given()
                .spec(requestSpec)
        .when()
                .get(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .spec(responseSpec)
                .statusCode(TestData.STATUS_OK)
                .body("id", equalTo(TestData.VALID_POST_ID))
                .body("userId", equalTo(TestData.EXPECTED_USER_ID))
                .body("title", startsWith(TestData.EXPECTED_TITLE_START))
                .body("body", notNullValue());
    }

//    Post not found
    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("GET /posts/999 - Non-existent post returns 404")
    @Description("Verify GET with invalid ID returns 404 and empty body")
    public void testGetPostNotFound(){
        given()
                .spec(requestSpec)
        .when()
                .get(TestData.POSTS_ENDPOINT + "/" + TestData.INVALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_NOT_FOUND)
                .body(equalTo("{}"));
    }

//    Validate response matches JSON schema
    @Test
    @Order(4)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("GET /posts/1 - Response matches JSON schema")
    @Description("Verify response structure matches the expected post JSON schema")
    public void testGetPostSchemaValidation(){
        given()
                .spec(requestSpec)
        .when()
                .get(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }

//    Validate response headers and performance
    @Test
    @Order(5)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("GET /posts/1 - Correct headers and acceptable response time")
    @Description("Verify Content-Type header and response time under threshold")
    public void testGetResponseHeaders(){
        given()
                .spec(requestSpec)
        .when()
                .get(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .header("Content-Type", containsString("application/json"))
                .time(lessThan(TestData.MAX_RESPONSE_TIME_MS));
    }
}
