package com.demo.user.registration.exception;

public class IpNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IpNotFoundException(String msg) {
        super(msg);
    }
}
