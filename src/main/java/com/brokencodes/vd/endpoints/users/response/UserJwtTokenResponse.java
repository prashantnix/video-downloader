package com.brokencodes.vd.endpoints.users.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserJwtTokenResponse {

    private String email;

    private String token;

    private String userId;

}
