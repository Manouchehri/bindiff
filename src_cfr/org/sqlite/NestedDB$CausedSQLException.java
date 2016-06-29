/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.PrintWriter;
import java.sql.SQLException;

final class NestedDB$CausedSQLException
extends SQLException {
    private final Exception cause;

    NestedDB$CausedSQLException(Exception exception) {
        if (exception == null) {
            throw new RuntimeException("null exception cause");
        }
        this.cause = exception;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }

    @Override
    public void printStackTrace() {
        this.cause.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintWriter printWriter) {
        this.cause.printStackTrace(printWriter);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this.cause.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return this.cause.getStackTrace();
    }

    @Override
    public String getMessage() {
        return this.cause.getMessage();
    }
}

