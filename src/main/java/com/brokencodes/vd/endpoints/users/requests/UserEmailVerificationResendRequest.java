package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UserEmailVerificationResendRequest implements IValidateRequest {

    private String email;

    @Override
    public Validation validate() {
        return StringUtils.isBlank(email) ? new Validation("Provide a valid email id") : null;
    }

}
