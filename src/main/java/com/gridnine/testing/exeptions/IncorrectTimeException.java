package com.gridnine.testing.exeptions;

public class IncorrectTimeException extends IllegalArgumentException {
    public IncorrectTimeException(String s) {
        super(s);
    }
}
