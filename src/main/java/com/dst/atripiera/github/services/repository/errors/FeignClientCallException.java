package com.dst.atripiera.github.services.repository.errors;

public class FeignClientCallException extends RuntimeException {
    private final Integer status;

    public FeignClientCallException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}