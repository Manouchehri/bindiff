/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

public class Runtime$ExecutionException
extends Exception {
    private String message = "(null)";
    private String location = "(unknown)";

    public Runtime$ExecutionException() {
    }

    public Runtime$ExecutionException(String string) {
        if (string == null) return;
        this.message = string;
    }

    void setLocation(String string) {
        this.location = string == null ? "(unknown)" : string;
    }

    @Override
    public final String getMessage() {
        return new StringBuffer().append(this.message).append(" at ").append(this.location).toString();
    }
}

