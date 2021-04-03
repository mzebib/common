package com.github.mzebib.common.service;

/**
 * @author mzebib
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

}