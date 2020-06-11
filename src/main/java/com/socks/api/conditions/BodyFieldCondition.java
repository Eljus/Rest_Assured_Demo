package com.socks.api.conditions;

import com.jayway.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyFieldCondition implements Condition{

    private final String jsonPath;
    private final Matcher matcher;

    @Override
    public void check(Response response) {
        response.then().assertThat().body(jsonPath, matcher);
    }

    @Override
    public String toString() {
        return "body field [" + jsonPath + "] " + matcher;
    }
}
