package com.brokencodes.vd.endpoints.users.requests;

import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import lombok.Data;

import java.util.Optional;

@Data
public class UserIdentificationWithEmailAndPasswordRequest implements IValidateRequest {

    private String email;

    private String password;

    @Override
    public Optional<Validation> validate() {
        return Optional.empty();
    }

}
