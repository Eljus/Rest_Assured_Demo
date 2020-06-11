package com.socks.api.conditions;

import com.jayway.restassured.response.Response;

public interface Condition {

    void check(Response response);
}
