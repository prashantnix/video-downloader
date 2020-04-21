package com.brokencodes.vd.endpoints.base;

import java.util.Optional;

/**
 * Use this hook to validate request objects.
 */
public interface IValidateRequest {

    /**
     * This method provides validation logic for request object.
     * @return Validation instance
     */
    Optional<Validation> validate();
}
