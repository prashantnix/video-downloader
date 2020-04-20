package com.brokencodes.vd.beans.ydl;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public enum TimeUnit {
    SECOND(ChronoUnit.SECONDS, "s"),
    MINUTE(ChronoUnit.MINUTES, "m"),
    HOUR(ChronoUnit.HOURS, "h"),
    DAY(ChronoUnit.DAYS, "d");

    private final ChronoUnit unit;

    private final String symbol;

    TimeUnit(ChronoUnit unit, String symbol) {
        this.unit = unit;
        this.symbol = symbol;
    }

    public ChronoUnit getUnit() {
        return unit;
    }

    public static ChronoUnit getUnit(String symbol) {
        return Arrays.stream(values())
                .filter(timeUnit -> timeUnit.symbol.equalsIgnoreCase(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid symbol for time unit" + symbol))
                .unit;
    }
}
