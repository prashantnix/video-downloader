package com.brokencodes.vd.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class VdEnableWebRequestLoggingConfigurations {

    @Bean
    @ConditionalOnProperty(
            name = "vd.features.enable-endpoint-request-logging",
            havingValue = "true"
    )
    public CommonsRequestLoggingFilter enableRequestFilter() {
        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
        commonsRequestLoggingFilter.setIncludePayload(true);
        commonsRequestLoggingFilter.setIncludeQueryString(true);
        commonsRequestLoggingFilter.setMaxPayloadLength(10000);
        commonsRequestLoggingFilter.setIncludeHeaders(true);
        commonsRequestLoggingFilter.setAfterMessagePrefix("REQUEST DATA: ");
        return commonsRequestLoggingFilter;
    }
}
