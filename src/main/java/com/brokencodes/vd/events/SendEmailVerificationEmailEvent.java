package com.brokencodes.vd.events;

import com.brokencodes.vd.beans.users.User;
import lombok.Getter;

@Getter
public class SendEmailVerificationEmailEvent {

    private final User user;

    /**
     * Object is of type {@link com.brokencodes.vd.beans.users.User} whose email needs to be verified.
     * @param user whose email needs to be verified
     */
    public SendEmailVerificationEmailEvent(final User user) {
        this.user = user;
    }

}
