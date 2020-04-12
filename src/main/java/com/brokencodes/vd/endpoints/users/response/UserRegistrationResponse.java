package com.brokencodes.vd.endpoints.users.response;

import com.brokencodes.vd.endpoints.base.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationResponse extends BaseResponse {

    private String userId;
}
