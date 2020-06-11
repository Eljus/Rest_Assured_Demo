package com.socks.tests;

import com.github.javafaker.Faker;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.socks.api.ProjectConfig;
import com.socks.api.conditions.Condition;
import com.socks.api.conditions.Conditions;
import com.socks.api.conditions.StatusCodeCondition;
import com.socks.api.payloads.UserPayloads;
import com.socks.api.services.UserApiService;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.Matchers.*;


public class UserTest {
    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp(){
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
         this.faker = new Faker(new Locale(config.local()));
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void testCanRegisterNewUser() {
        UserPayloads user = new UserPayloads()
                .name(faker.name().fullName())
                .job(faker.job().position());

        userApiService
                .registerUser(user)
                .shouldHave(Conditions.statusCode(201))
                .shouldHave(Conditions.bodyField("id", not(isEmptyOrNullString())))
                .headers();
    }
}
