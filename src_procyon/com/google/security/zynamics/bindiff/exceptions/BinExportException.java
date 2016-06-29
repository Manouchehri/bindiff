package com.google.security.zynamics.bindiff.exceptions;

public class BinExportException extends Exception
{
    public BinExportException(final Exception ex) {
        super(ex);
    }
    
    public BinExportException(final Exception ex, final String s) {
        super(s, ex);
    }
    
    public BinExportException(final String s) {
        super(s);
    }
}
