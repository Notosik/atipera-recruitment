package com.dst.atripiera.github.api;

import com.dst.atripiera.github.services.repository.errors.FeignClientCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class RestControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiError> handleException(
            Exception ex) {
        final var status = HttpStatus.INTERNAL_SERVER_ERROR;
        final var error = new ApiError(status.value(), "Something went wrong, please contact administrator");
        logger.error(
                "{}", ex.getMessage(),
                ex
        );

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(FeignClientCallException.class)
    ResponseEntity<ApiError> handleFeignClientCallException(FeignClientCallException ex) {
        final var status = HttpStatus.valueOf(ex.getStatus());
        final var error = new ApiError(status.value(), ex.getMessage());

        return ResponseEntity.status(status).body(error);
    }
}
