package com.keer.banking.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                           String message,
                           String details,
                           String errorCode) {

}

/*
What ErrorDetails Represents?
It’s a data container for sending structured error info to the client when an exception is thrown.
 */