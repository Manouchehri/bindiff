package com.google.protobuf;

public class ServiceException extends Exception
{
    private static final long serialVersionUID = -1219262335729891920L;
    
    public ServiceException(final String s) {
        super(s);
    }
    
    public ServiceException(final Throwable t) {
        super(t);
    }
    
    public ServiceException(final String s, final Throwable t) {
        super(s, t);
    }
}
