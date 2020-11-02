package com.drapala.quiz2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public static final String QUIZ_NOT_FOUND = "Quiz not found";
    public static final String QUESTION_NOT_FOUND = "Question not found";
    public static final String INVALID_UID = "Invalid quiz uid";

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
