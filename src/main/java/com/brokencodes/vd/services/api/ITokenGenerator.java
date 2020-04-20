package com.brokencodes.vd.services.api;

import com.brokencodes.vd.beans.ydl.Token;

public interface ITokenGenerator {

    String generateFixedTokenFromString(String seed);

    String generateDynamicTokenFromString(String seed);

    Token generateStoredTokenFromString(String seed, String timeOut);

}
