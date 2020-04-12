package com.brokencodes.vd.endpoints.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseResponse {

    protected String message;

    protected LocalDateTime generatedAt = LocalDateTime.now();
}
