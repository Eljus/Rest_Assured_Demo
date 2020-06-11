package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserPayloads;


public class UserApiService extends ApiService {


    public AssertableResponse registerUser(UserPayloads user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("users"));
    }
}
