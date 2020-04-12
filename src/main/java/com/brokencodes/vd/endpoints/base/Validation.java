package com.brokencodes.vd.endpoints.base;

import lombok.Data;

@Data
public class Validation {

    private String message;

    private boolean isFailed;

    public Validation(String message) {
        this(message, true);
    }

    public Validation(String message, boolean isFailed) {
        this.message = message;
        this.isFailed = isFailed;
    }

}
