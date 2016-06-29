package com.google.security.zynamics.bindiff.exceptions;

public class DifferException extends Exception
{
    public DifferException(final Exception ex, final String s) {
        super(s, ex);
    }
    
    public DifferException(final String s) {
        super(s);
    }
}
