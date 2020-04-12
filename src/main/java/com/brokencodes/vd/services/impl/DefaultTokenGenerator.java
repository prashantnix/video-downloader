package com.brokencodes.vd.services.impl;

import com.brokencodes.vd.services.api.ITokenGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultTokenGenerator implements ITokenGenerator {

    @Override
    public String generateTokenFromString(String seed) {
        return UUID.nameUUIDFromBytes(seed.getBytes()).toString();
    }

}
