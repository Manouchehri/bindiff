package org.sqlite;

import java.sql.*;
import java.io.*;

final class NestedDB$CausedSQLException extends SQLException
{
    private final Exception cause;
    
    NestedDB$CausedSQLException(final Exception cause) {
        if (cause == null) {
            throw new RuntimeException("null exception cause");
        }
        this.cause = cause;
    }
    
    public Throwable getCause() {
        return this.cause;
    }
    
    public void printStackTrace() {
        this.cause.printStackTrace();
    }
    
    public void printStackTrace(final PrintWriter printWriter) {
        this.cause.printStackTrace(printWriter);
    }
    
    public Throwable fillInStackTrace() {
        return this.cause.fillInStackTrace();
    }
    
    public StackTraceElement[] getStackTrace() {
        return this.cause.getStackTrace();
    }
    
    public String getMessage() {
        return this.cause.getMessage();
    }
}
