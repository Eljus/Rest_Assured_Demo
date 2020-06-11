package com.socks.api.assertions;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.socks.api.conditions.Condition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(Condition condition){
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass){
        return response.as(tClass);
    }

    public Headers headers(){
        /*log.info("------------------------------------------");
        log.info(String.valueOf(response.getHeaders()));*/
        return response.getHeaders();
    }
}
