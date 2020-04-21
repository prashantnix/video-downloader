package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.endpoints.base.Validation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserIdentificationWithEmailAndTokenRequest extends UserIdentificationWithEmailRequest {

    private String token;

    @Override
    public Optional<Validation> validate() {
        Optional<Validation> emailValidation = super.validate();
        if (emailValidation.isPresent()) {
            return emailValidation;
        }
        if (StringUtils.isBlank(token)) {
            return Optional.of(new Validation("Token must be provided"));
        }
        return Optional.empty();
    }

}
