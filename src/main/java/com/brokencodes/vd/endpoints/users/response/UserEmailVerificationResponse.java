package com.brokencodes.vd.endpoints.users.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEmailVerificationResponse {

    private String message;

}
