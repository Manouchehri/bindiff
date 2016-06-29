/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.exceptions;

public class GraphCreationException
extends Exception {
    public GraphCreationException(Exception exception, String string) {
        super(string, exception);
    }

    public GraphCreationException(String string) {
        super(string);
    }
}

