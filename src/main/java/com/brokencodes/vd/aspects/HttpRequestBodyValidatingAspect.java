package com.brokencodes.vd.aspects;

import com.brokencodes.vd.annotations.ValidateRequestBody;
import com.brokencodes.vd.endpoints.base.IValidateRequest;
import com.brokencodes.vd.endpoints.base.Validation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class HttpRequestBodyValidatingAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestBodyValidatingAspect.class);

    @Before("@annotation(validateRequestBody)")
    public void validateRequestBodyAdvice(JoinPoint joinPoint, ValidateRequestBody validateRequestBody) {
        if (!validateRequestBody.enabled()) {
            return;
        }
        Arrays.stream(joinPoint.getArgs())
                .peek(arg -> logger.debug("Obtained argument {} on method {}", arg, joinPoint.getSignature().getName()))
                .filter(arg -> arg instanceof IValidateRequest)
                .map(arg -> (IValidateRequest) arg)
                .map(IValidateRequest::validate)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(Validation::isFailed)
                .findFirst()
                .ifPresent(failedValidation -> { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, failedValidation.getMessage()); });
    }

}
