package com.brokencodes.vd.events;

import com.brokencodes.vd.services.api.IMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class SendEmailVerificationEmailEventListener {

    private static final String MAIL_WELCOME_SENDER = "welcome@vd.com";

    private static final String WELCOME_MESSAGE_FORMAT = "Please use {0} as account activation and verification code";

    public static final String WELCOME_MAIL_SUBJECT = "Account activation code";

    @Autowired
    private IMailSenderService mailSenderService;

    @Async
    @EventListener
    public void sendEmailVerificationEmail(SendEmailVerificationEmailEvent event) {
        mailSenderService.send(
                MAIL_WELCOME_SENDER,
                event.getUser().getEmail(),
                WELCOME_MAIL_SUBJECT,
                MessageFormat.format(WELCOME_MESSAGE_FORMAT, event.getUser().getAccountVerificationToken().getToken())
        );
    }

}
