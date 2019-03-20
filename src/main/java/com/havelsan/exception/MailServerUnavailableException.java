package com.havelsan.exception;

public class MailServerUnavailableException extends RuntimeException {
    public MailServerUnavailableException(String message) {
        super(message);
    }
}
