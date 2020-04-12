package com.brokencodes.vd.aspects;

import com.brokencodes.vd.annotations.ValidateRequestBody;
import com.brokencodes.vd.endpoints.base.IValidateRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class HttpRequestBodyValidatingAspect {

    @Before("@annotation(validateRequestBody)")
    public void validateRequestBodyAdvice(JoinPoint joinPoint, ValidateRequestBody validateRequestBody) {
        Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg instanceof IValidateRequest)
                .map(arg -> (IValidateRequest) arg)
                .map(IValidateRequest::validate)
                .filter(Objects::nonNull)
                .filter(validation -> validation.isFailed())
                .findFirst()
                .ifPresent(failedValidation -> { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, failedValidation.getMessage()); });
    }
}
