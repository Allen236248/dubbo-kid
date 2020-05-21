package com.allen.dubbo.xml.validator;

public class ParameterErrorException extends RuntimeException {

    public ParameterErrorException() {
        super();
    }

    public ParameterErrorException(String message) {
        super(message);
    }

    public ParameterErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
