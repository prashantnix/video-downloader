package com.brokencodes.vd.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.Executor;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
public class VdConfigurations {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Executor taskExecutor(
            @Value("${vd.async.core-pool-size: 2}") int corePoolSize,
            @Value("${vd.async.max-pool-size: 2}") int maxPoolSize,
            @Value("${vd.async.queue-capacity: 500}") int queueCapacity,
            @Value("${vd.async.thread-name-prefix: VD-ASYNC-}") String threadNamePrefix) {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }

}
