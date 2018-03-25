package ru.itis.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendMail(String text, String subject, String email);
}

