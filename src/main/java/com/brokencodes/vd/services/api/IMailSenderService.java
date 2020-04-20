package com.brokencodes.vd.services.api;

public interface IMailSenderService {

    void send(String sender, String recipient, String subject, String message);

}
