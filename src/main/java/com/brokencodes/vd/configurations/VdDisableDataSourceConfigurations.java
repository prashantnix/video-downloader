package com.brokencodes.vd.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Setting the value of the property: vd.features.disable-data-source to true activates this configuration
 * and disables all connections to the data source.
 */
@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ConditionalOnProperty(
        name = "vd.features.disable-data-source",
        havingValue = "true"
)
public class VdDisableDataSourceConfigurations {

}
