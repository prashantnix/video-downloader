package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@Data
public class UserIdentificationWithEmailRequest implements IValidateRequest {

    private String email;

    @Override
    public Optional<Validation> validate() {
        return StringUtils.isBlank(email) ? Optional.of(new Validation("Provide a valid email id")) : Optional.empty();
    }

}
