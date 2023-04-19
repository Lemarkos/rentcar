package kg.rentcar.emailsender.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
