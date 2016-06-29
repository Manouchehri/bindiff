/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.exceptions;

public class BinExportException
extends Exception {
    public BinExportException(Exception exception) {
        super(exception);
    }

    public BinExportException(Exception exception, String string) {
        super(string, exception);
    }

    public BinExportException(String string) {
        super(string);
    }
}

