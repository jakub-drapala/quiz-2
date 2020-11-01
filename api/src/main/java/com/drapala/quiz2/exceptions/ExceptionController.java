package com.drapala.quiz2.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiExceptionDescription> handleResourceNotFoundException(Exception e) {
        return new ResponseEntity<>(new ApiExceptionDescription(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class ApiExceptionDescription {
        private Integer httpCode;
        private String httpSeries;
        private String message;

        public ApiExceptionDescription() {
        }

        public ApiExceptionDescription(String message) {
            this.message = message;
        }

        public ApiExceptionDescription(Integer httpCode, String message) {
            this.httpCode = httpCode;
            this.message = message;
        }

        public String getHttpSeries() {
            return this.httpSeries;
        }

        public void setHttpSeries(String httpSeries) {
            this.httpSeries = httpSeries;
        }

        public Integer getHttpCode() {
            return this.httpCode;
        }

        public void setHttpCode(Integer httpCode) {
            this.httpCode = httpCode;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
