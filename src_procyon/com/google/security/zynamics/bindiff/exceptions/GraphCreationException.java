package com.google.security.zynamics.bindiff.exceptions;

public class GraphCreationException extends Exception
{
    public GraphCreationException(final Exception ex, final String s) {
        super(s, ex);
    }
    
    public GraphCreationException(final String s) {
        super(s);
    }
}
