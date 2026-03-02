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

@Feature("PUT Requests")
public class PutTest extends BaseTest {

//    full update of an existing post
    @Test
    @Order(1)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("PUT /posts/1 - Full update returns 200")
    @Description("Verify PUT /posts/1 updates all fields and returns 200 with updated data")
    public void testUpdatePost(){
        given()
                .spec(requestSpec)
                .body(TestData.updatePostPayload())
        .when()
                .put(TestData.POSTS_ENDPOINT + "/" +TestData.VALID_POST_ID)
        .then()
                .spec(responseSpec)
                .statusCode(TestData.STATUS_OK)
                .body("id", equalTo(TestData.VALID_POST_ID))
                .body("title", equalTo("Updated Post Title"))
                .body("body", equalTo("This post body has been updated."))
                .body("userId", equalTo(TestData.VALID_USER_ID));
    }

//    Partial update(only title)
    @Test
    @Order(2)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("PUT /posts/1 - Partial update works")
    @Description("Verify PUT with only title field still returns 200")
    public void testUpdatePostPartial(){
        given()
                .spec(requestSpec)
                .body(TestData.partialUpdatePayload())
        .when()
                .put(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .body("title", equalTo("Only Title Updated"))
                .body("id", equalTo(TestData.VALID_POST_ID));
    }

//    Verify response has correct headers
    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("PUT /posts/1 - Correct Content-Type header")
    @Description("Verify PUT response returns correct Content-Type header")
    public void testUpdateResponseHeaders(){
        given()
                .spec(requestSpec)
                .body(TestData.headerTestPayload())
        .when()
                .put(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .header("Content-Type", containsString("application/json"));
    }

//    Verify response time is acceptable
    @Test
    @Order(4)
    @Severity(SeverityLevel.MINOR)
    @DisplayName("PUT /posts/1 - Response time under threshold")
    @Description("Verify PUT response completes within acceptable time")
    public void testUpdateResponseTime(){
        given()
                .spec(requestSpec)
                .body(TestData.performanceTestPayload())
        .when()
                .put(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .time(lessThan(TestData.MAX_RESPONSE_TIME_MS));
    }
}
