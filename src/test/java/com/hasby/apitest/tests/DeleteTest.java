package com.hasby.apitest.tests;

import com.hasby.apitest.base.BaseTest;
import com.hasby.apitest.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteTest extends BaseTest {

//    Delete an existing post
    @Test
    @Order(1)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("DELETE /posts/1 - Delete post returns 200")
    @Description("Verify DELETE /posts/1 returns 200 confirming deletion")
    public void testDeletePost(){
        given()
                .spec(requestSpec)
        .when()
                .delete(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK);
    }

//    Verify delete returns empty body
    @Test
    @Order(2)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("DELETE /posts/1 - Response body is empty object")
    @Description("Verify DELETE response body is an empty JSON object {}")
    public void testDeleteEmptyBody(){
        given()
                .spec(requestSpec)
        .when()
                .delete(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .body("isEmpty()", is(true));
    }

//    Verify response time is acceptable
    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("DELETE /posts/1 - Response time under threshold")
    @Description("Verify DELETE operation completes within acceptable time")
    public void testDeleteResponseTime(){
        given()
                .spec(requestSpec)
        .when()
                .delete(TestData.POSTS_ENDPOINT + "/" + TestData.VALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK)
                .time(lessThan(TestData.MAX_RESPONSE_TIME_MS));
    }

//    Delete non-existent post
    @Test
    @Order(4)
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("DELETE /posts/999 - Non-existent post behavior")
    @Description("Verify DELETE for non-existent post — jsonplaceholder returns 200 (real API would return 404)")
    public void testDeleteNonExistentPost(){
        given()
                .spec(requestSpec)
        .when()
                .delete(TestData.POSTS_ENDPOINT + "/" + TestData.INVALID_POST_ID)
        .then()
                .statusCode(TestData.STATUS_OK);
    }
}
