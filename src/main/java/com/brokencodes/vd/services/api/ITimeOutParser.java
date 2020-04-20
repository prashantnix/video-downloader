package com.brokencodes.vd.services.api;

import lombok.Builder;
import lombok.Data;

import java.time.temporal.ChronoUnit;

public interface ITimeOutParser {

    @Data
    @Builder
    class TimeOut {

        private long timeOut;

        private ChronoUnit unit;

    }

    TimeOut getTimeOut(String timeOut);

}
