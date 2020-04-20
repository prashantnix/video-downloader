package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UserEmailVerificationRequest implements IValidateRequest {

    private String email;

    private String token;

    @Override
    public Validation validate() {
        if (StringUtils.isBlank(email)) {
            return new Validation("Email id must be provided");
        }
        if (StringUtils.isBlank(token)) {
            return new Validation("Token must be provided");
        }
        return null;
    }

}
