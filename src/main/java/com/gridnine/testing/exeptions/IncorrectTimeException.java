package com.gridnine.testing.exeptions;

/**
 * Exception for incorrect input time
 */
public class IncorrectTimeException extends IllegalArgumentException {
    public IncorrectTimeException(String s) {
        super(s);
    }
}
