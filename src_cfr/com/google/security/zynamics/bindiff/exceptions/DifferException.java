/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.exceptions;

public class DifferException
extends Exception {
    public DifferException(Exception exception, String string) {
        super(string, exception);
    }

    public DifferException(String string) {
        super(string);
    }
}

