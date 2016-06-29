/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.exceptions;

public class GraphLayoutException
extends Exception {
    public GraphLayoutException(Exception exception, String string) {
        super(string, exception);
    }

    public GraphLayoutException(String string) {
        super(string);
    }
}

