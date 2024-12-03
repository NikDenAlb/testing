package com.gridnine.testing.exeptions;

/**
 * Exception for negative wait time between segments. Does not applies to broken segments.
 */
public class NegativeWaitException extends RuntimeException {
    public NegativeWaitException(String message) {
        super(message);
    }
}
