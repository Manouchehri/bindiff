package com.google.security.zynamics.bindiff.exceptions;

public class GraphLayoutException extends Exception
{
    public GraphLayoutException(final Exception ex, final String s) {
        super(s, ex);
    }
    
    public GraphLayoutException(final String s) {
        super(s);
    }
}
