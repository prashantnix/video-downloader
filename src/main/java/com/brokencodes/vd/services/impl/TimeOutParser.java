package com.brokencodes.vd.services.impl;

import com.brokencodes.vd.beans.ydl.TimeUnit;
import com.brokencodes.vd.services.api.ITimeOutParser;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TimeOutParser implements ITimeOutParser {

    private static final Pattern TIMEOUT_PATTERN = Pattern.compile("([0-9].*)([a-zA-Z])");

    public static final int GROUP_TIME_DURATION = 1;

    public static final int GROUP_TIME_UNIT_SYMBOL = 2;

    @Override
    public TimeOut getTimeOut(String timeOut) {
        Matcher timeOutMatching = TIMEOUT_PATTERN.matcher(timeOut);
        if (!timeOutMatching.find()) {
            throw new IllegalArgumentException("Provided timeout value is not valid");
        }
        return TimeOut.builder()
                .timeOut(Long.parseLong(timeOutMatching.group(GROUP_TIME_DURATION)))
                .unit(TimeUnit.getUnit(timeOutMatching.group(GROUP_TIME_UNIT_SYMBOL)))
                .build();
    }

}
