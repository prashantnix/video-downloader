package com.brokencodes.vd.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Setting the value of the property: vd.features.disable-security to true activates this configuration
 * and disables all the security features.
 */
@Configuration
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@ConditionalOnProperty(
        name = "vd.features.disable-security",
        havingValue = "true"
)
public class VdDisableSecurityConfigurations {

}
