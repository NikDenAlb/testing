package com.gridnine.testing.exeptions;

public class NegativeWaitException extends RuntimeException {
    public NegativeWaitException(String message) {
        super(message);
    }
}
