package com.brokencodes.vd.endpoints.base;

/**
 * Use this hook to validate request objects.
 */
public interface IValidateRequest {

    /**
     * This method provides validation logic for request object.
     * @return Validation instance
     */
    Validation validate();
}
