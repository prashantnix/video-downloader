package com.brokencodes.vd.services.impl;

import com.brokencodes.vd.beans.ydl.TimeUnit;
import com.brokencodes.vd.beans.ydl.Token;
import com.brokencodes.vd.repositories.TokenRepository;
import com.brokencodes.vd.services.api.ITimeOutParser;
import com.brokencodes.vd.services.api.ITokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DefaultTokenGenerator implements ITokenGenerator {

    private static final String DYNAMIC_SEED_FORMAT = "{0}-{1}-{2}";

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private ITimeOutParser timeOutParser;

    @Override
    public String generateFixedTokenFromString(final String seed) {
        return UUID.nameUUIDFromBytes(seed.getBytes()).toString();
    }

    @Override
    public String generateDynamicTokenFromString(String seed) {
        return generateFixedTokenFromString(MessageFormat.format(
                DYNAMIC_SEED_FORMAT,
                seed,
                LocalDateTime.now().getNano(),
                UUID.randomUUID()));
    }

    @Override
    public Token generateStoredTokenFromString(String seed, String timeOut) {
        LocalDateTime now = LocalDateTime.now();
        ITimeOutParser.TimeOut timeOutInstance = timeOutParser.getTimeOut(timeOut);
        return Token.builder()
                .createdAt(now)
                .expiresOn(now.plus(timeOutInstance.getTimeOut(), timeOutInstance.getUnit()))
                .token(generateDynamicTokenFromString(seed))
                .build();
    }

}
